package com.example.note_app_kotllin.data.repostories

import com.example.note_app_kotllin.data.datasoruces.local.NoteLocalDataSource
import com.example.note_app_kotllin.data.datasoruces.local.room.entities.NoteEntity
import com.example.note_app_kotllin.data.datasoruces.remote.datasources.NoteRemoteDataSource
import com.example.note_app_kotllin.domain.models.Note
import com.example.note_app_kotllin.domain.repositories.INotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotesRepository @Inject constructor(
    private val noteRemoteDataSource: NoteRemoteDataSource,
    private val noteLocalDataSource: NoteLocalDataSource
) : INotesRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        return noteLocalDataSource.getAllNotes()
            .map { entities -> entities.map { it.toDomainNote() } }
    }

    override suspend fun syncNotes(): Result<Unit> {
        return try {
            val response = noteRemoteDataSource.getAllNotes()
            val entities = response.data.notes.map { it.toEntityNote(isSynced = true) }
            noteLocalDataSource.insertNotes(entities)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


    override suspend fun getNoteById(id: String): Result<Note> {
        return try {
            val response = noteRemoteDataSource.getNoteById(id)
            val noteDto = response.data.note
            noteLocalDataSource.insertNote(noteDto.toEntityNote(isSynced = true))
            Result.success(noteDto.toDomainNote())
        } catch (e: Exception) {
            val localNote = noteLocalDataSource.getNoteById(id)
            if (localNote != null) {
                Result.success(localNote.toDomainNote())
            } else {
                Result.failure(e)
            }
        }
    }

    override suspend fun createNote(title: String, content: String): Result<Note> {
        val localId = UUID.randomUUID().toString()
        val currentTime = System.currentTimeMillis()

        val initialLocalEntity = NoteEntity(
            id = localId,
            title = title,
            content = content,
            createdAt = currentTime,
            updatedAt = currentTime,
            isSynced = false
        )
        noteLocalDataSource.insertNote(initialLocalEntity)

        return try {
            val response = noteRemoteDataSource.createNote(title, content)
            val noteDto = response.data.note

            noteLocalDataSource.deleteNoteById(localId)
            noteLocalDataSource.insertNote(noteDto.toEntityNote(isSynced = true))

            Result.success(noteDto.toDomainNote())
        } catch (e: Exception) {
//            Result.success(Note(localId, title, content, currentTime, currentTime))
            Result.failure(e)
        }
    }

    override suspend fun updateNote(id: String, title: String, content: String): Result<Note> {
        val currentTime = System.currentTimeMillis()

        val updatedLocalEntity = NoteEntity(
            id = id,
            title = title,
            content = content,
            createdAt = currentTime,
            updatedAt = currentTime,
            isSynced = false
        )
        noteLocalDataSource.insertNote(updatedLocalEntity)

        return try {
            val response = noteRemoteDataSource.updateNote(id, title, content)
            val noteDto = response.data.note

            noteLocalDataSource.insertNote(noteDto.toEntityNote(isSynced = true))
            Result.success(noteDto.toDomainNote())
        } catch (e: Exception) {
//            Result.success(Note(id, title, content, currentTime, currentTime))
            Result.failure(e)
        }
    }

    override suspend fun deleteNote(id: String): Result<Unit> {
        return try {
            noteRemoteDataSource.deleteNoteById(id)
            noteLocalDataSource.deleteNoteById(id)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteAllNotes(): Result<Unit> {
        return try {
            noteRemoteDataSource.deleteAllNotes()
            noteLocalDataSource.deleteAllNotes()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
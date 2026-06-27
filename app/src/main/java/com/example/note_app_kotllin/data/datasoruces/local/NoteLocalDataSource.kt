package com.example.note_app_kotllin.data.datasoruces.local

import com.example.note_app_kotllin.data.datasoruces.local.room.daos.NoteDao
import com.example.note_app_kotllin.data.datasoruces.local.room.entities.NoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteLocalDataSource @Inject constructor(
    private val noteDao: NoteDao
) {
    fun getAllNotes(): Flow<List<NoteEntity>> = noteDao.getAllNotes()

    suspend fun getNoteById(id: String): NoteEntity? = noteDao.getNoteById(id)

    suspend fun insertNote(note: NoteEntity) = noteDao.insertNote(note)

    suspend fun insertNotes(notes: List<NoteEntity>) {
        notes.forEach { noteDao.insertNote(it) }
    }

    suspend fun deleteNote(note: NoteEntity) = noteDao.deleteNote(note)

    suspend fun deleteNoteById(id: String) = noteDao.deleteNoteById(id)

    suspend fun deleteAllNotes() = noteDao.deleteAllNotes()
}
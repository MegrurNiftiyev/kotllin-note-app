package com.example.note_app_kotllin.data.datasoruces.local.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.note_app_kotllin.data.datasoruces.local.room.entities.NoteEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Query("SELECT * FROM Notes WHERE isDeleted = 0 ORDER BY createdAt DESC")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM Notes WHERE id = :noteId LIMIT 1")
    suspend fun getNoteById(noteId: String): NoteEntity?

    @Query("DELETE FROM Notes WHERE id = :noteId")
    suspend fun deleteNoteById(noteId: String)

    @Query("DELETE FROM Notes")
    suspend fun deleteAllNotes()

    @Query("SELECT * FROM Notes WHERE isDeleted = 1 AND isSynced = 0")
    suspend fun getLocallyDeletedNotes(): List<NoteEntity>

}
package com.example.note_app_kotllin.data.datasoruces.local.room.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.note_app_kotllin.data.datasoruces.local.room.entities.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Query("SELECT * FROM Notes ORDER BY createdAt DESC")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM Notes WHERE id = :noteId LIMIT 1")
    suspend fun getNoteById(noteId: String): NoteEntity?

    @Delete
    suspend fun deleteNote(note: NoteEntity)
}
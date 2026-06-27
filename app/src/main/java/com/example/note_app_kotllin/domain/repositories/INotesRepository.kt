package com.example.note_app_kotllin.domain.repositories

import com.example.note_app_kotllin.domain.models.Note

interface INotesRepository {

    suspend fun getAllNotes(): Result<List<Note>>

    suspend fun getNoteById(id: String): Result<Note>

    suspend fun createNote(title: String, content: String): Result<Note>

    suspend fun updateNote(id: String, title: String, content: String): Result<Note>

    suspend fun deleteNote(id: String): Result<Unit>

    suspend fun deleteAllNotes(): Result<Unit>
}
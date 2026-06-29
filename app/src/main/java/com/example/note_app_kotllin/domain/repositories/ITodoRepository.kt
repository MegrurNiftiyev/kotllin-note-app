package com.example.note_app_kotllin.domain.repositories

import com.example.note_app_kotllin.domain.models.Note
import com.example.note_app_kotllin.domain.models.Todo
import kotlinx.coroutines.flow.Flow

interface ITodoRepository {





     fun getAllTodos(): Flow<List<Todo>>

    suspend fun syncNotes(): Result<Unit>

    suspend fun getTodoById(id: String): Result<Todo>
    suspend fun createTodo(note: Note): Result<Todo>
    suspend fun updateTodo(note: Note): Result<Todo>
    suspend fun deleteTodo(id: String): Result<Unit>
    suspend fun deleteAllTodos(): Result<Unit>
}
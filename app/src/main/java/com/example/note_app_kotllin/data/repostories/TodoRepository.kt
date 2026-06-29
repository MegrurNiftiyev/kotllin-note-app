package com.example.note_app_kotllin.data.repostories


import com.example.note_app_kotllin.domain.models.Note
import com.example.note_app_kotllin.domain.models.Todo
import com.example.note_app_kotllin.domain.repositories.ITodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRepository @Inject constructor(): ITodoRepository {


    override fun getAllTodos(): Flow<List<Todo>> {
        TODO("Not yet implemented")
    }

    override suspend fun syncNotes(): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getTodoById(id: String): Result<Todo> {
        TODO("Not yet implemented")
    }

    override suspend fun createTodo(note: Note): Result<Todo> {
        TODO("Not yet implemented")
    }

    override suspend fun updateTodo(note: Note): Result<Todo> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTodo(id: String): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllTodos(): Result<Unit> {
        TODO("Not yet implemented")
    }
}
package com.example.note_app_kotllin.data.repostories


import com.example.note_app_kotllin.data.datasoruces.local.TodoLocalDataSource
import com.example.note_app_kotllin.data.datasoruces.remote.datasources.TodoRemoteDataSource
import com.example.note_app_kotllin.domain.models.Note
import com.example.note_app_kotllin.domain.models.Todo
import com.example.note_app_kotllin.domain.repositories.ITodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRepository @Inject constructor(
  private val  todoLocalDataSource: TodoLocalDataSource,
   private val  todoRemoteDataSource: TodoRemoteDataSource
): ITodoRepository {


    override fun getAllTodos(): Flow<List<Todo>> {
       return  todoLocalDataSource.getAllTodos().map{
      entities -> entities.map{it.toDomainTodo()}
       }
    }

    override suspend fun syncTodos(): Result<Unit> {
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
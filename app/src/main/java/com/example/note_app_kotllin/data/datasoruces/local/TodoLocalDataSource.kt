package com.example.note_app_kotllin.data.datasoruces.local

import com.example.note_app_kotllin.data.datasoruces.local.room.entities.TodoEntity
import com.example.note_app_kotllin.data.datasoruces.local.room.daos.TodoDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoLocalDataSource @Inject constructor(
    private val todoDao: TodoDao
) {
    fun getAllTodos(): Flow<List<TodoEntity>> = todoDao.getAllTodos()

    suspend fun getTodoById(id: String): TodoEntity? = todoDao.getTodoById(id)

    suspend fun insertTodo(todo: TodoEntity) = todoDao.insertTodo(todo)

    suspend fun insertTodos(todos: List<TodoEntity>) {
        todos.forEach { todoDao.insertTodo(it) }

    }

    suspend fun getLocallyDeletedTodos(): List<TodoEntity> = todoDao.getLocallyDeletedTodos()

    suspend fun deleteTodoById(id: String) = todoDao.deleteTodoById(id)

    suspend fun deleteAllTodos() = todoDao.deleteAllTodos()
}



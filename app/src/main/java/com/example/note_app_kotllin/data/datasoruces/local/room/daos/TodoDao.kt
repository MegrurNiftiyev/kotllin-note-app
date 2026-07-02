package com.example.todo_app_kotllin.data.datasoruces.local.room.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.note_app_kotllin.data.datasoruces.local.room.entities.TodoEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: TodoEntity)

    @Query("SELECT * FROM Todos WHERE isDeleted = 0 ORDER BY createdAt DESC")
    fun getAllTodos(): Flow<List<TodoEntity>>

    @Query("SELECT * FROM Todos WHERE id = :todoId LIMIT 1")
    suspend fun getTodoById(todoId: String): TodoEntity?

    @Query("DELETE FROM Todos WHERE id = :todoId")
    suspend fun deleteTodoById(todoId: String)

    @Query("DELETE FROM Todos")
    suspend fun deleteAllTodos()

    @Query("SELECT * FROM Todos WHERE isDeleted = 1 AND isSynced = 0")
    suspend fun getLocallyDeletedTodos(): List<TodoEntity>
}
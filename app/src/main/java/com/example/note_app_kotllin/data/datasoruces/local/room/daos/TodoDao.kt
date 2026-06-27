package com.example.note_app_kotllin.data.datasoruces.local.room.daos

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
    suspend fun insertNote(todo: TodoEntity)

    @Query("SELECT * FROM Todos ORDER BY createdAt DESC")
    fun getAllNotes(): Flow<List<TodoEntity>>

    @Query("SELECT * FROM Todos WHERE id = :todoId LIMIT 1")
    suspend fun getNoteById(todoId: String): TodoEntity?

    @Delete
    suspend fun deleteNote(todo: TodoEntity)
}
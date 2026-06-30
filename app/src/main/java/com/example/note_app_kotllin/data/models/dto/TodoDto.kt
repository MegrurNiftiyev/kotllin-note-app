package com.example.note_app_kotllin.data.models.dto

import com.example.note_app_kotllin.data.datasoruces.local.room.entities.NoteEntity
import com.example.note_app_kotllin.data.datasoruces.local.room.entities.TodoEntity
import com.example.note_app_kotllin.domain.models.Note
import com.example.note_app_kotllin.domain.models.Todo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TodoDto (
    @SerialName("_id") val id: String,
    val description: String,
    val isCompleted: Boolean = false,
    val createdAt: String,
    val updatedAt: String
)


{
    fun toDomainTodo(): Todo {
        return Todo(
            id = this.id,
            description = this.description,
            isCompleted = this.isCompleted,
            createdAt = this.createdAt.toLongOrNull() ?: System.currentTimeMillis(),
            updatedAt = this.updatedAt.toLongOrNull() ?: System.currentTimeMillis(),
            isSynced = true

        )
    }

    fun toEntityTodo(isSynced: Boolean): TodoEntity {
        return TodoEntity(
            id = this.id,
            description = this.description,
            isCompleted = this.isCompleted,
            createdAt = this.createdAt.toLongOrNull() ?: System.currentTimeMillis(),
            updatedAt = this.updatedAt.toLongOrNull() ?: System.currentTimeMillis(),
            isSynced = true
        )
    }
}
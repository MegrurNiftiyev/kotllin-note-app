package com.example.note_app_kotllin.data.models.dto

import com.example.note_app_kotllin.data.datasoruces.local.room.entities.NoteEntity
import com.example.note_app_kotllin.domain.models.Note
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NoteDto(
    @SerialName("_id") val id: String,
    val title: String,
    val content: String,
    val createdAt: String,
    val updatedAt: String
) {
    fun toDomainNote(): Note {
        return Note(
            id = this.id,
            title = this.title,
            content = this.content,
            createdAt = this.createdAt.toLongOrNull() ?: System.currentTimeMillis(),
            updatedAt = this.updatedAt.toLongOrNull() ?: System.currentTimeMillis()
        )
    }

    fun toEntityNote(isSynced: Boolean): NoteEntity {
        return NoteEntity(
            id = this.id,
            title = this.title,
            content = this.content,
            createdAt = this.createdAt.toLongOrNull() ?: System.currentTimeMillis(),
            updatedAt = this.updatedAt.toLongOrNull() ?: System.currentTimeMillis(),
            isSynced = isSynced
        )
    }
}

fun Note.toEntityNote(isSynced: Boolean): NoteEntity {
    return NoteEntity(
        id = this.id,
        title = this.title,
        content = this.content,
        createdAt = this.createdAt ,
        updatedAt = this.updatedAt ,
        isSynced = isSynced
    )
}
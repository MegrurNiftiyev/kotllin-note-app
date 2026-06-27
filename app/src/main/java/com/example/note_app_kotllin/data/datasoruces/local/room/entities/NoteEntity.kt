package com.example.note_app_kotllin.data.datasoruces.local.room.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.note_app_kotllin.domain.models.Note

@Entity(tableName = "Notes")
data class NoteEntity(
    @PrimaryKey val id: String,
    val title: String,
    val content: String,
    val createdAt: Long,
    val updatedAt: Long,
    val isSynced: Boolean,
    val isDeleted: Boolean = false

){
    fun toDomainNote(): Note {
        return Note(
            id = this.id,
            title = this.title,
            content = this.content,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )
    }
}

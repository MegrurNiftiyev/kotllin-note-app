package com.example.note_app_kotllin.data.datasoruces.local.room.entities


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class NoteEntity(
    @PrimaryKey val id: String,
    val title: String,
    val content: String,
    val createdAt: Long,
    val updatedAt: Long,
    val isSynced: Boolean,
)

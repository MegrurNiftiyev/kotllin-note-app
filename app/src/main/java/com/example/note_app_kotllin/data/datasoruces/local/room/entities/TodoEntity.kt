package com.example.note_app_kotllin.data.datasoruces.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Todos")
data class TodoEntity (
    @PrimaryKey val id: String,
    val description: String,
    val isCompleted: Boolean,
    val createdAt: Long,
    val updatedAt: Long,
    val isSynced: Boolean,
    val isDeleted: Boolean = false

)
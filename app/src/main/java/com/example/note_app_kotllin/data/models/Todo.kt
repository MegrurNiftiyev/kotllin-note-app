package com.example.note_app_kotllin.data.models

data class Todo(
    val id: String,
    val description: String,
    val isCompleted: Boolean = false
)

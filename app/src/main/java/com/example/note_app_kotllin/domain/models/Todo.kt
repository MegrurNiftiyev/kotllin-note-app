package com.example.note_app_kotllin.domain.models

data class Todo(
    val id: String,
    val description: String,
    val isCompleted: Boolean = false
)

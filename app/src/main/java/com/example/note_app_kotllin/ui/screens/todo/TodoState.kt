package com.example.note_app_kotllin.ui.screens.todo

import com.example.note_app_kotllin.domain.models.Todo

data class TodoState (
    val todos: List<Todo> = emptyList()
)


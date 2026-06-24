package com.example.note_app_kotllin.ui.screens.todo

import com.example.note_app_kotllin.data.models.Todo

data class TodoState (
    val todos: List<Todo> = emptyList()
)


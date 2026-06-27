package com.example.note_app_kotllin.ui.screens.notes

import com.example.note_app_kotllin.domain.models.Note

data class NotesState(
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val notes: List<Note> = emptyList(),
    val errorMessage: String? = null
)
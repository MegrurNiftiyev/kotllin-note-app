package com.example.note_app_kotllin.ui.screens.notes

import com.example.note_app_kotllin.domain.models.Note

data class NotesState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
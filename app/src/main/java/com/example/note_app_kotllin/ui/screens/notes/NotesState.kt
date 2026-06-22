package com.example.note_app_kotllin.ui.screens.notes

import androidx.compose.runtime.mutableStateListOf
import com.example.note_app_kotllin.data.models.Note

data class NotesState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
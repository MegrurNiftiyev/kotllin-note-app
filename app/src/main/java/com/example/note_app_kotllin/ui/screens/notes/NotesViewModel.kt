package com.example.note_app_kotllin.ui.screens.notes

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.note_app_kotllin.domain.models.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class NotesViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(NotesState())

    val state: StateFlow<NotesState> = _state.asStateFlow()

    fun fetchNotes() {
        _state.update { it.copy() }
    }

    fun addNote(title: String, content: String) {
        _state.update { it.copy(notes = it.notes + Note(title = title, content = content)) }
    }

    init {
        mutableStateListOf<Note>(
            Note(
                title = "Shopping List",
                content = "Buy milk, bread, eggs, and butter from the local grocery store."
            ),
            Note(
                title = "University Tasks",
                content = "Review the layers of the OSI model for the Informatics exam."
            ),
            Note(
                title = "Coding Projects",
                content = "Refactor the mobile app navigation using Jetpack Compose."
            ),
            Note(
                title = "Piano Maintenance",
                content = "Check the tuning and internal mechanism of the acoustic piano."
            ),
            Note(
                title = "Random Ideas",
                content = "Research Server-Driven UI concepts and how to handle dynamic routes."
            )
        ).forEach { note ->
            addNote(note.title, note.content)
        }
    }
}
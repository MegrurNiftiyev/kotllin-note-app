package com.example.note_app_kotllin.ui.screens.notes

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.note_app_kotllin.data.models.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NotesViewModel @Inject constructor() : ViewModel() {
    val notesList = mutableStateListOf<Note>(
        Note(title = "Shopping List", subtitle = "Buy milk, bread, eggs, and butter from the local grocery store."),
        Note(title = "University Tasks", subtitle = "Review the layers of the OSI model for the Informatics exam."),
        Note(title = "Coding Projects", subtitle = "Refactor the mobile app navigation using Jetpack Compose."),
        Note(title = "Piano Maintenance", subtitle = "Check the tuning and internal mechanism of the acoustic piano."),
        Note(title = "Random Ideas", subtitle = "Research Server-Driven UI concepts and how to handle dynamic routes.")
    )

    fun addNote(title: String, subtitle: String) {
      notesList.add(Note(title=title, subtitle = subtitle))
    }
}
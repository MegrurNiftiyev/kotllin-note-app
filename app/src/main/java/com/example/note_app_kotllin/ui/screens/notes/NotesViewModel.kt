package com.example.note_app_kotllin.ui.screens.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_app_kotllin.domain.repositories.INotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesRepository: INotesRepository
) : ViewModel() {

    private val _state = MutableStateFlow(NotesState())
    val state: StateFlow<NotesState> = _state.asStateFlow()

    init {
        fetchNotes()
    }

    fun refreshNotes() {
        _state.update { it.copy(isRefreshing = true) }
        fetchNotes()
    }

    fun fetchNotes() {
        viewModelScope.launch {
            if (!_state.value.isRefreshing) {
                _state.update { it.copy(isLoading = true, errorMessage = null) }
            }
            notesRepository.getAllNotes()
                .onSuccess { notesList ->
                    _state.update {
                        it.copy(notes = notesList, isLoading = false, isRefreshing = false)
                    }
                }
                .onFailure { exception ->
                    _state.update {
                        it.copy(errorMessage = exception.localizedMessage, isLoading = false, isRefreshing = false)
                    }
                }
        }
    }
}
package com.example.note_app_kotllin.ui.screens.todo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor() : ViewModel() {

     private  val _state    = MutableStateFlow(TodoState())
            val state: StateFlow<TodoState> = _state.asStateFlow()
}

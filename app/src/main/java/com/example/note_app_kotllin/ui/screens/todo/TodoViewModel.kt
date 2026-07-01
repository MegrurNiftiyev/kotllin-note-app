package com.example.note_app_kotllin.ui.screens.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_app_kotllin.domain.models.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(TodoState())
    val state: StateFlow<TodoState> = _state.asStateFlow()


    init {
        getTodos()
    }

    fun getTodos() {
        val todos: List<Todo> = listOf(
            Todo("1", "Todo 1", false, isSynced = false),
            Todo("2", "Todo 2", false, isSynced = false),
            Todo("3", "Todo 3", true, isSynced = false),
        )
        viewModelScope.launch {
            _state.update {
                it.copy(todos = todos)
            }
        }
    }

    fun createTodo(){

    }
}

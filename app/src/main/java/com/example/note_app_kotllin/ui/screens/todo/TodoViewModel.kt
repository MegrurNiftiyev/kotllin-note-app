package com.example.note_app_kotllin.ui.screens.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_app_kotllin.data.repostories.TodoRepository
import com.example.note_app_kotllin.domain.models.Todo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository
) : ViewModel() {

    private val _state = MutableStateFlow(TodoState())
    val state: StateFlow<TodoState> = _state.asStateFlow()

    init {
        listenLocalTodos()
        syncTodos()
    }

    private fun listenLocalTodos() {
        viewModelScope.launch(IO) {
            todoRepository.getAllTodos().collect { todos ->
                _state.update { it.copy(todos = todos) }
            }
        }
    }

    private fun syncTodos() {
        viewModelScope.launch(IO) {
            _state.update { it.copy(isLoading = true) }
            todoRepository.syncTodos()
            _state.update { it.copy(isLoading = false) }
        }
    }

    fun createTodo() {
        if (_state.value.draftTodo != null) return

        val now = System.currentTimeMillis()
        val draft = Todo(
            id = "",
            description = "",
            isCompleted = false,
            createdAt = now,
            updatedAt = now,
            isSynced = false
        )
        _state.update { it.copy(draftTodo = draft, focusedTodoId = "", focusedText = "") }
    }

    fun onFocusGained(id: String, currentText: String) {
        _state.update { it.copy(focusedTodoId = id, focusedText = currentText) }
    }

    fun onTextChange(text: String) {
        _state.update { it.copy(focusedText = text) }
    }

    fun handleFocusLost(id: String, finalText: String, isCompleted: Boolean) {
        saveOrDeleteTodo(id, finalText, isCompleted)
        _state.update { it.copy(focusedTodoId = null, focusedText = "") }
    }

    fun handleScreenExit() {
        val current = _state.value
        val id = current.focusedTodoId ?: return
        val isCompleted = current.todos.find { it.id == id }?.isCompleted ?: false

        saveOrDeleteTodo(id, current.focusedText, isCompleted)
        _state.update { it.copy(focusedTodoId = null, focusedText = "") }
    }

    private fun saveOrDeleteTodo(id: String, text: String, isCompleted: Boolean) {
        val trimmed = text.trim()

        if (id.isEmpty()) {
            if (trimmed.isEmpty()) {
                _state.update { it.copy(draftTodo = null) }
            } else {
                viewModelScope.launch {
                    withContext(NonCancellable) {
                        todoRepository.createTodo(description = trimmed, isCompleted = false)
                    }
                }
                _state.update { it.copy(draftTodo = null) }
            }
        } else {
            if (trimmed.isEmpty()) {
                viewModelScope.launch {
                    withContext(NonCancellable) { todoRepository.deleteTodo(id) }
                }
            } else {
                viewModelScope.launch {
                    withContext(NonCancellable) { todoRepository.updateTodo(id, trimmed, isCompleted) }
                }
            }
        }
    }

    fun updateTodoCompletion(id: String, description: String, isCompleted: Boolean) {
        viewModelScope.launch {
            todoRepository.updateTodo(id, description, isCompleted)
        }
    }

    fun deleteTodo(id: String) {
        if (_state.value.focusedTodoId == id) {
            _state.update { it.copy(focusedTodoId = null, focusedText = "") }
        }
        viewModelScope.launch {
            withContext(NonCancellable) { todoRepository.deleteTodo(id) }
        }
    }
}
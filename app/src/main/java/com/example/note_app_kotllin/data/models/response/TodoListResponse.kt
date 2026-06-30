package com.example.note_app_kotllin.data.models.response

import com.example.note_app_kotllin.data.models.dto.TodoDto
import kotlinx.serialization.Serializable

@Serializable
data class TodoListResponse(
    val status: String,
    val results: Int,
    val data: TodoList
) {
    @Serializable
    data class TodoList(val notes: List<TodoDto>)
}
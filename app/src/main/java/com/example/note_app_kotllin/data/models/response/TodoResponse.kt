package com.example.note_app_kotllin.data.models.response


import com.example.note_app_kotllin.data.models.dto.TodoDto
import com.example.note_app_kotllin.domain.models.Todo
import kotlinx.serialization.Serializable

@Serializable
data class TodoResponse (
    val status: String,
    val data: Todo
){
    @Serializable
    data class Todo(val todo: TodoDto)
}



package com.example.note_app_kotllin.data.models.response

import com.example.note_app_kotllin.data.models.dto.NoteDto
import kotlinx.serialization.Serializable

@Serializable
data class NoteResponse(
    val status: String,
    val data: Note
){
    @Serializable
    data class Note(val note:NoteDto)
}
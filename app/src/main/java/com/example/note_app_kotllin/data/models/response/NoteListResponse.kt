package com.example.note_app_kotllin.data.models.response

import com.example.note_app_kotllin.data.models.dto.NoteDto
import kotlinx.serialization.Serializable

@Serializable
data class NoteListResponse(
    val status: String,
    val results: Int,
    val data: NoteList
) {
    @Serializable
    data class NoteList(val notes: List<NoteDto>)
}
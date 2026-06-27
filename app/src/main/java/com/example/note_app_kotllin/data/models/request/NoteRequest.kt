package com.example.note_app_kotllin.data.models.request

import kotlinx.serialization.Serializable

@Serializable
data class NoteRequest(
    val title: String,
    val content: String
)
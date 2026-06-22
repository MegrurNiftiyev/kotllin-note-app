package com.example.note_app_kotllin.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Register

@Serializable
object Notes

@Serializable
object Settings

@Serializable
data class NoteDetail(
    val id: String,
    val title: String,
    val subtitle: String
)
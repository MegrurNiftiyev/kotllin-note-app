package com.example.note_app_kotllin.data.models.request

import kotlinx.serialization.Serializable

@Serializable

data class LogoutRequest (
    val refreshToken: String
)
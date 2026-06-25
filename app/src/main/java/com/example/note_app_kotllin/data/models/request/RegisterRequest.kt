package com.example.note_app_kotllin.data.models.request

data class RegisterRequest (
    val name: String,
    val email: String,
    val password : String
)
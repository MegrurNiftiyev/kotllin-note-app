package com.example.note_app_kotllin.data.datasoruces.remote.models.request

data class RegisterRequest (
    val name: String,
    val email: String,
    val password : String
)
package com.example.note_app_kotllin.ui.screens.auth.register

data class RegisterState (
    val isLoading: Boolean=false,
    val isSuccess:Boolean=false,
    val errorMessage: String? = null,
    val userNameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmPasswordError: String? = null,
)
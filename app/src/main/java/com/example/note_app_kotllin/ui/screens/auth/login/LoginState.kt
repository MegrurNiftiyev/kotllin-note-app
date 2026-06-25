package com.example.note_app_kotllin.ui.screens.auth.login

data class LoginState (
    val isLoading: Boolean=false,
    val isSuccess:Boolean=false,
    val errorMessage: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    )
package com.example.note_app_kotllin.ui.screens.auth.login

import com.example.note_app_kotllin.core.util.UiText

data class LoginState (
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: UiText? = null,
    val emailError: UiText? = null,
    val passwordError: UiText? = null,
)
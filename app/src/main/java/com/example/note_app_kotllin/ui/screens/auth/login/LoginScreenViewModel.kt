package com.example.note_app_kotllin.ui.screens.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_app_kotllin.core.exceptions.AuthException
import com.example.note_app_kotllin.core.exceptions.NetworkException
import com.example.note_app_kotllin.core.extensions.isValidEmail
import com.example.note_app_kotllin.core.extensions.isValidPassword
import com.example.note_app_kotllin.domain.repositories.IAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val authRepository: IAuthRepository
) : ViewModel() {


    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun login(email: String, password: String) {
        if (!validate(email, password)) return
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, errorMessage = null) }
            authRepository.login(email, password).onSuccess {
                _state.update { it.copy(isLoading = false, isSuccess = true) }
            }.onFailure { e ->
                val error = when (e) {
                    is AuthException.InvalidCredentials -> "sifre ve ya emil yanlisdir"
                    is AuthException.TooManyRequests -> "Çox sayda cəhd. Bir az gözləyin"
                    is NetworkException.NoInternet -> "İnternet bağlantısı yoxdur"
                    else -> "Xəta baş verdi"
                }
                _state.update {
                    it.copy(isLoading = false, errorMessage = error)
                }
            }
        }
    }


    private fun validate(
        email: String,
        password: String,
    ): Boolean {


        val emailError = when {
            email.isBlank() -> "Email boş ola bilməz"
            !email.isValidEmail() -> "Düzgün email daxil edin"
            else -> null
        }

        val passwordError = when {
            password.isBlank() -> "Şifrə boş ola bilməz"
            !password.isValidPassword() -> "sifre ve ya emil yanlisdir"
            else -> null
        }



        _state.update {
            it.copy(
                emailError = emailError,
                passwordError = passwordError,
            )
        }

        return listOf(emailError, passwordError).all { it == null }
    }
}
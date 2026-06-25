package com.example.note_app_kotllin.ui.screens.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.note_app_kotllin.core.exceptions.AuthException
import com.example.note_app_kotllin.core.exceptions.NetworkException
import com.example.note_app_kotllin.core.extensions.isValidEmail
import com.example.note_app_kotllin.core.extensions.isValidPassword
import com.example.note_app_kotllin.core.extensions.isValidUserName
import com.example.note_app_kotllin.domain.repositories.IAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: IAuthRepository
): ViewModel() {

     private val _state = MutableStateFlow(RegisterState())
    val state=_state.asStateFlow()

    fun register(userName: String, email: String, password: String, confirmPassword: String) {
        if (!validate(userName, email, password,confirmPassword)) return

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, errorMessage = null) }

            authRepository.register(userName, email, password)
                .onSuccess {
                    _state.update { it.copy(isLoading = false, isSuccess = true) }
                }
                .onFailure { e ->
                    val error = when (e) {
                        is AuthException.EmailAlreadyExists -> "Bu email artıq qeydiyyatdan keçib"
                        is AuthException.TooManyRequests -> "Çox sayda cəhd. Bir az gözləyin"
                        is NetworkException.NoInternet -> "İnternet bağlantısı yoxdur"
                        else -> "Xəta baş verdi"
                    }
                    _state.update { it.copy(isLoading = false, errorMessage = error) }
                }
        }
    }

    private fun validate(
        userName: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        val userNameError = when {
            userName.isBlank() -> "İstifadəçi adı boş ola bilməz"
            !userName.isValidUserName() -> "Ən az 3 simvol, yalnız hərf, rəqəm, nöqtə və tire"
            else -> null
        }

        val emailError = when {
            email.isBlank() -> "Email boş ola bilməz"
            !email.isValidEmail() -> "Düzgün email daxil edin"
            else -> null
        }

        val passwordError = when {
            password.isBlank() -> "Şifrə boş ola bilməz"
            !password.isValidPassword() -> "Ən az 8 simvol, böyük/kiçik hərf, rəqəm və xüsusi işarə"
            else -> null
        }

        val confirmPasswordError = when {
            confirmPassword.isBlank() -> "Şifrəni təkrar daxil edin"
            confirmPassword != password -> "Şifrələr uyğun gəlmir"
            else -> null
        }

        _state.update {
            it.copy(
                userNameError = userNameError,
                emailError = emailError,
                passwordError = passwordError,
                confirmPasswordError = confirmPasswordError
            )
        }

        return listOf(userNameError, emailError, passwordError, confirmPasswordError)
            .all { it == null }
    }
}
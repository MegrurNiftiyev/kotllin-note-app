package com.example.note_app_kotllin.ui.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_app_kotllin.core.constants.CacheKeys
import com.example.note_app_kotllin.core.managers.EncryptedCacheManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val encryptedCacheManager: EncryptedCacheManager
) : ViewModel() {

    private val _state = MutableStateFlow(SplashState())
    val state: StateFlow<SplashState> = _state.asStateFlow()

    init {
        checkAuthentication()
    }

    private fun checkAuthentication() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            val token = encryptedCacheManager.getSecureString(CacheKeys.ACCESS_TOKEN)
            if (!token.isNullOrBlank()) {
                _state.update { it.copy(isAuthenticated = true, isLoading = false) }
            } else {
                _state.update { it.copy(isAuthenticated = false, isLoading = false) }
            }
        }
    }
}
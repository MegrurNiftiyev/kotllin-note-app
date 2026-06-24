package com.example.note_app_kotllin.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_app_kotllin.data.repostories.interfaces.ISettingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val settingsRepository: ISettingsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = _state.asStateFlow()


    init {
        viewModelScope.launch {
            settingsRepository.isDarkMode.collect { darkMode ->
                _state.update { it.copy(isDarkMode = darkMode) }
            }
        }
    }

    fun changeThemeMode() {
        viewModelScope.launch {
            val currentMode = _state.value.isDarkMode
            settingsRepository.changeTheme(!currentMode)
        }
    }

    fun openLanguageSheet() {
        _state.update { it.copy(isLanguageSheetOpen = true) }
    }

    fun closeLanguageSheet() {
        _state.update { it.copy(isLanguageSheetOpen = false) }
    }
}
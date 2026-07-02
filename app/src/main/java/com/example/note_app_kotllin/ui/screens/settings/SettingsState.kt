package com.example.note_app_kotllin.ui.screens.settings

data class SettingsState(
    val isDarkMode: Boolean = true,
    val isLanguageSheetOpen: Boolean = false,
    val userName:String="userName",
    val userEmail:String="Email"
)

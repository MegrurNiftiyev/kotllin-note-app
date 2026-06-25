package com.example.note_app_kotllin.domain.repositories

import kotlinx.coroutines.flow.Flow

interface ISettingsRepository {

    val  isDarkMode : Flow<Boolean>

    suspend fun changeTheme(isDarkMode: Boolean)

    suspend fun clearSettingsCache()

}
package com.example.note_app_kotllin.data.repostories.interfaces

import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

interface ISettingsRepository {

    val  isDarkMode : Flow<Boolean>

    suspend fun changeTheme(isDarkMode: Boolean)

    suspend fun clearSettingsCache()

}
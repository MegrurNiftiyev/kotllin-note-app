package com.example.note_app_kotllin.data.datasoruces.local.interfaces

import kotlinx.coroutines.flow.Flow


interface ISettingsLocalDataSource {

    val isDarkMode: Flow<Boolean>

    suspend fun changeTheme(isDarkMode: Boolean)

    suspend fun clearSettingsCache()

}
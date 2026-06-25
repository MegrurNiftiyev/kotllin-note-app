package com.example.note_app_kotllin.data.repostories

import com.example.note_app_kotllin.data.datasoruces.local.SettingsLocalDataSource
import com.example.note_app_kotllin.domain.repositories.ISettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsRepository @Inject constructor(
    private val localDataSource: SettingsLocalDataSource
) : ISettingsRepository {
    override val isDarkMode: Flow<Boolean>
        get() {
            return localDataSource.isDarkMode
        }

    override suspend fun changeTheme(isDarkMode: Boolean) {
        localDataSource.changeTheme(isDarkMode)
    }

    override suspend fun clearSettingsCache() {
        localDataSource.clearSettingsCache()
    }
}



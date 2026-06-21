package com.example.note_app_kotllin.data.repostories

import com.example.note_app_kotllin.data.datasoruces.local.interfaces.ISettingsLocalDataSource
import com.example.note_app_kotllin.data.repostories.interfaces.ISettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsRepository @Inject constructor(
    private val localDataSource: ISettingsLocalDataSource
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



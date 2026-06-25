package com.example.note_app_kotllin.data.datasoruces.local

import com.example.note_app_kotllin.core.constants.CacheKeys
import com.example.note_app_kotllin.core.managers.CacheManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsLocalDataSource @Inject constructor(
    private val cacheManager: CacheManager
)  {
     val isDarkMode: Flow<Boolean>
        get() {
            return cacheManager.getBoolean(CacheKeys.IS_DARK_MODE)
        }

     suspend fun changeTheme(isDarkMode: Boolean) {
        cacheManager.setBoolean(CacheKeys.IS_DARK_MODE, isDarkMode)
    }

     suspend fun clearSettingsCache() {
        cacheManager.clearAllCache()
    }

}
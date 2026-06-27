package com.example.note_app_kotllin.data.datasoruces.local

import com.example.note_app_kotllin.data.datasoruces.local.room.daos.UserDao
import com.example.note_app_kotllin.data.datasoruces.local.room.entities.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLocalDataSource @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun saveUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun getCurrentUser(): Flow<UserEntity> {
        return userDao.getCurrentUser()
    }

    suspend fun clearUser() {
        userDao.clearUser()
    }
}
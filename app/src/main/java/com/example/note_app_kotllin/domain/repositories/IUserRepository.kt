package com.example.note_app_kotllin.domain.repositories

import com.example.note_app_kotllin.domain.models.User


interface IUserRepository {
    suspend fun getUser(): Result<User>
    suspend fun updateUser(user: User): Result<User>
    suspend fun deleteUser(): Result<Unit>

}
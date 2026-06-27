package com.example.note_app_kotllin.data.repostories

import com.example.note_app_kotllin.domain.models.User
import com.example.note_app_kotllin.domain.repositories.IUserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(

): IUserRepository{
    override suspend fun getUser(): Result<User> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: User): Result<User> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(): Result<Unit> {
        TODO("Not yet implemented")
    }
}


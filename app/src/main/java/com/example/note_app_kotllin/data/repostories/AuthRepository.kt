package com.example.note_app_kotllin.data.repostories

import com.example.note_app_kotllin.data.datasoruces.remote.datasources.AuthRemoteDataSource
import com.example.note_app_kotllin.domain.models.User
import com.example.note_app_kotllin.domain.repositories.IAuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource
) : IAuthRepository {
    override suspend fun register(
        userName: String,
        email: String,
        password: String
    ): Result<User> {
        TODO("Not yet implemented")
    }

    override suspend fun login(
        email: String,
        password: String
    ): Result<User> {
        TODO("Not yet implemented")
    }

    override suspend fun logout(): Result<Unit> {
        TODO("Not yet implemented")
    }


}
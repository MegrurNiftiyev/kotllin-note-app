package com.example.note_app_kotllin.data.repostories

import com.example.note_app_kotllin.data.datasoruces.remote.datasources.AuthRemoteDataSource
import com.example.note_app_kotllin.data.datasoruces.remote.models.request.LoginRequest
import com.example.note_app_kotllin.data.datasoruces.remote.models.request.LogoutRequest
import com.example.note_app_kotllin.data.datasoruces.remote.models.request.RegisterRequest
import com.example.note_app_kotllin.data.datasoruces.remote.models.response.LoginResponse
import com.example.note_app_kotllin.data.datasoruces.remote.models.response.RegisterResponse
import com.example.note_app_kotllin.data.repostories.interfaces.IAuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource
) : IAuthRepository {

    override suspend fun register(request: RegisterRequest): Result<RegisterResponse> {
        TODO("Not yet implemented")

    }

    override suspend fun login(request: LoginRequest): Result<LoginResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun logout(request: LogoutRequest): Result<Unit> {
        TODO("Not yet implemented")
    }

}
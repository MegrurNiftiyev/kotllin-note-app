package com.example.note_app_kotllin.data.repostories.interfaces

import com.example.note_app_kotllin.data.datasoruces.remote.models.request.LoginRequest
import com.example.note_app_kotllin.data.datasoruces.remote.models.request.LogoutRequest
import com.example.note_app_kotllin.data.datasoruces.remote.models.request.RegisterRequest
import com.example.note_app_kotllin.data.datasoruces.remote.models.response.LoginResponse
import com.example.note_app_kotllin.data.datasoruces.remote.models.response.RegisterResponse

interface  IAuthRepository{
    suspend fun register(request: RegisterRequest): Result<RegisterResponse>
    suspend fun login(request: LoginRequest): Result<LoginResponse>

    suspend fun logout(request: LogoutRequest): Result<Unit>
}
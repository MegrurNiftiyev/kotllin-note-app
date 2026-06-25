package com.example.note_app_kotllin.domain.repositories

import com.example.note_app_kotllin.data.models.request.LoginRequest
import com.example.note_app_kotllin.data.models.request.LogoutRequest
import com.example.note_app_kotllin.data.models.request.RegisterRequest
import com.example.note_app_kotllin.data.models.response.LoginResponse
import com.example.note_app_kotllin.data.models.response.RegisterResponse
import com.example.note_app_kotllin.domain.models.User

interface  IAuthRepository{
    suspend fun register(userName: String,email: String,password: String): Result<User>
    suspend fun login(email: String,password: String): Result<User>

    suspend fun logout(): Result<Unit>
}
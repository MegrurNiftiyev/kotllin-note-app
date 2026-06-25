package com.example.note_app_kotllin.data.datasoruces.remote.datasources

import com.example.note_app_kotllin.data.models.request.LoginRequest
import com.example.note_app_kotllin.data.models.request.LogoutRequest
import com.example.note_app_kotllin.data.models.request.RefreshRequest
import com.example.note_app_kotllin.data.models.request.RegisterRequest
import com.example.note_app_kotllin.data.models.response.LoginResponse
import com.example.note_app_kotllin.data.models.response.RefreshResponse
import com.example.note_app_kotllin.data.models.response.RegisterResponse
import com.example.note_app_kotllin.data.datasoruces.remote.services.AuthApiService
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApiService: AuthApiService
) {

    suspend fun register(userName: String, email: String, password: String): Result<RegisterResponse> {
        return try {
            val response = authApiService.register(RegisterRequest(userName,email,password))
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(exception = Exception("Error ${e.message}"))
        }
    }

    suspend fun login(email: String, password: String): Result<LoginResponse> {
        return try {
            val response = authApiService.login(LoginRequest(email, password))
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(exception = Exception("Error ${e.message}"))
        }
    }

    suspend fun refresh(refreshToken: String): Result<RefreshResponse> {
        return  try{
            val response = authApiService.refresh(RefreshRequest(refreshToken))
            Result.success(response)
        }catch (e:Exception){
            Result.failure(exception = Exception("Error ${e.message}"))

        }
    }

    suspend fun logout(refreshToken: String): Result<Unit>{
        return  try {
            val response = authApiService.logout(LogoutRequest(refreshToken))
            Result.success(Unit)
        }catch (e: Exception) {
            Result.failure(exception = Exception("Error ${e.message}"))
        }
    }
}

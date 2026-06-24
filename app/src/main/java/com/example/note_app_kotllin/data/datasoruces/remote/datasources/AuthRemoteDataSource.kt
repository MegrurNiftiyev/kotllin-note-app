package com.example.note_app_kotllin.data.datasoruces.remote.datasources

import com.example.note_app_kotllin.data.datasoruces.remote.models.request.LoginRequest
import com.example.note_app_kotllin.data.datasoruces.remote.models.request.LogoutRequest
import com.example.note_app_kotllin.data.datasoruces.remote.models.request.RefreshRequest
import com.example.note_app_kotllin.data.datasoruces.remote.models.request.RegisterRequest
import com.example.note_app_kotllin.data.datasoruces.remote.models.response.LoginResponse
import com.example.note_app_kotllin.data.datasoruces.remote.models.response.RefreshResponse
import com.example.note_app_kotllin.data.datasoruces.remote.models.response.RegisterResponse
import com.example.note_app_kotllin.data.datasoruces.remote.services.AuthApiService
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApiService: AuthApiService
) {

    suspend fun register(request: RegisterRequest): Result<RegisterResponse> {
        return try {
            val response = authApiService.register(request)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(exception = Exception("Error ${e.message}"))
        }
    }

    suspend fun login(request: LoginRequest): Result<LoginResponse> {
        return try {
            val response = authApiService.login(request)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(exception = Exception("Error ${e.message}"))
        }
    }

    suspend fun refresh(request: RefreshRequest): Result<RefreshResponse> {
        return  try{
            val response = authApiService.refresh(request)
            Result.success(response)
        }catch (e:Exception){
            Result.failure(exception = Exception("Error ${e.message}"))

        }
    }

    suspend fun logout(request: LogoutRequest): Result<Unit>{
        return  try {
            val response = authApiService.logout(request)
            Result.success(Unit)
        }catch (e: Exception) {
            Result.failure(exception = Exception("Error ${e.message}"))
        }
    }
}

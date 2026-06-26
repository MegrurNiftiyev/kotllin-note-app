package com.example.note_app_kotllin.data.datasoruces.remote.services

import com.example.note_app_kotllin.data.models.request.UpdateUserRequest
import com.example.note_app_kotllin.data.models.response.UserResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH

interface UserApiService {

    @GET("/api/users/me")
    suspend fun getUser(): UserResponse

    @PATCH("/api/users/me")
    suspend fun updateUser(request: UpdateUserRequest): UserResponse

    @DELETE("/api/users/me")
    suspend fun deleteUser(): UserResponse
}
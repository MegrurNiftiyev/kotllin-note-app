package com.example.note_app_kotllin.data.datasoruces.remote.services

import com.example.note_app_kotllin.data.models.request.LoginRequest
import com.example.note_app_kotllin.data.models.request.LogoutRequest
import com.example.note_app_kotllin.data.models.request.RefreshRequest
import com.example.note_app_kotllin.data.models.request.RegisterRequest
import com.example.note_app_kotllin.data.models.response.LoginResponse
import com.example.note_app_kotllin.data.models.response.RefreshResponse
import com.example.note_app_kotllin.data.models.response.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

//api terfde mobile ve web clinlerden gelen responlar ferlqidi mobilde refresle berber accesde gelir ama webde
//Http only olduqu ucun bir basa cookiye yazilir ona gore Headers hissei elve edilib ve sadce auth
// endpiti ucun seciyyevidir bu qayda

interface AuthApiService {

    @Headers("X-Client-Type: mobile")
    @POST("/api/auth/register")
    suspend fun register(@Body registerRequest: RegisterRequest): RegisterResponse

    @Headers("X-Client-Type: mobile")
    @POST("/api/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @Headers("X-Client-Type: mobile")
    @POST("/api/auth/refresh")
    suspend fun refresh(@Body refreshRequest: RefreshRequest): RefreshResponse

    @Headers("X-Client-Type: mobile")
    @POST("/api/auth/logout")
    suspend fun logout(@Body logoutRequest: LogoutRequest): Unit

}
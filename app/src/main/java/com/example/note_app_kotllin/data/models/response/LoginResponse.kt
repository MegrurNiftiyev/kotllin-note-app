package com.example.note_app_kotllin.data.models.response


import com.example.note_app_kotllin.data.models.dto.UserDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse (
    @SerialName("status") val status: String,
    @SerialName("accessToken") val accessToken : String,
    @SerialName("refreshToken") val refreshToken : String,
    @SerialName("user") val user: UserDto
)
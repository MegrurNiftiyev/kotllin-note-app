package com.example.note_app_kotllin.data.models.response

import com.example.note_app_kotllin.data.models.dto.UserDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse (
    @SerialName("status") val status: String,
    @SerialName("data") val data: UserDto,
)
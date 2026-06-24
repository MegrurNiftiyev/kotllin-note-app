package com.example.note_app_kotllin.data.datasoruces.remote.models.response

import com.example.note_app_kotllin.data.datasoruces.remote.models.dto.UserDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class  RegisterResponse (
   @SerialName("status") val status: String,
   @SerialName("accessToken") val accessToken : String,
   @SerialName("refreshToken") val refreshToken : String,
   @SerialName("user") val user: UserDto
)





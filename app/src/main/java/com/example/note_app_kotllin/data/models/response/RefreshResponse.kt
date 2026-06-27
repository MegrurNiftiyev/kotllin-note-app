package com.example.note_app_kotllin.data.models.response

import com.example.note_app_kotllin.data.models.dto.AuthDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshResponse(
    @SerialName("status") val status: String,
    @SerialName("data") val data: AuthDto,

    )

//example response
//{
//    "status": "success",
//    "data":
//    {
//        "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
//        "refreshToken": "a3f1c2e4b5d6...",
//         "user": {
//         "_id": "665f2a797a6ef0cb8d3a7d1a",
//         "name": "Ada Lovelace",
//         "email": "ada@example.com",
//         "createdAt": "2026-06-25T07:16:02.202Z"
//     }
//    }
//}
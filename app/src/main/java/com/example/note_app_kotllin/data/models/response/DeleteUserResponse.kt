package com.example.note_app_kotllin.data.models.response

import kotlinx.serialization.SerialName

data class DeleteUserResponse(
    @SerialName("status") val status: String,
    @SerialName("deletedUserId") val deletedUserId: String,
    @SerialName("deletedNotesCount") val deletedNotesCount: Int
)
package com.example.note_app_kotllin.data.models.dto

import com.example.note_app_kotllin.domain.models.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserDto(
    @SerialName("_id") val id:String,
    @SerialName("name") val name:String,
    @SerialName("email") val email:String,
    @SerialName("createdAt") val createdAt:String,


){
    fun toDomainUser(): User {
        return User(
            id = this.id,
            name = this.name,
            email = this.email,
            createdAt = this.createdAt
        )
    }
}

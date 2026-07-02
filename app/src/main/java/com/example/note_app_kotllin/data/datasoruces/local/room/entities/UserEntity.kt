package com.example.note_app_kotllin.data.datasoruces.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.note_app_kotllin.domain.models.User

@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey val id: String,
    val name: String,
    val email: String,
    val createdAt: Long,
) {
    fun toDomainUser(): User {
        return User(
            id = id,
            name = name,
            email = email,
            createdAt = createdAt,
        )
    }
}

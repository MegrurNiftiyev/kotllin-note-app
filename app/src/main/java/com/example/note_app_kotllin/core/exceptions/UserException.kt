package com.example.note_app_kotllin.core.exceptions

sealed class UserException(override val message: String) : Exception() {
    data class Unauthorized(override val message: String = "Missing, invalid, or expired token") : UserException(message)
    data class UserNotFound(override val message: String = "User not found") : UserException(message)
    data class ValidationError(override val message: String = "Name or email is required, or validation failed") : UserException(message)
    data class EmailAlreadyRegistered(override val message: String = "Email is already registered") : UserException(message)
    data class ServerError(override val message: String = "Something went wrong on server") : UserException(message)
    data class Unknown(override val message: String = "An unexpected error occurred") : UserException(message)
}
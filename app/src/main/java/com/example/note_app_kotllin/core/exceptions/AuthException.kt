package com.example.note_app_kotllin.core.exceptions

sealed class AuthException(override val message: String) : Exception() {
    data class InvalidCredentials(override val message: String = "Incorrect email or password") : AuthException(message)
    data class UserNotFound(override val message: String = "User not found") : AuthException(message)
    data class EmailAlreadyExists(override val message: String = "This email is already registered") : AuthException(message)
    data class ValidationError(override val message: String = "Provided data is invalid") : AuthException(message)
    data class InvalidRefreshToken(override val message: String = "Session expired, please log in again") : AuthException(message)
    data class TooManyRequests(override val message: String = "Too many attempts. Please wait a moment") : AuthException(message)
    data class TokenNotFound(override val message: String="Token not found in cache") : AuthException(message)
    data class ServerError(override val message: String = "Internal server error") : AuthException(message)
    data class Unknown(override val message: String = "An unexpected error occurred") : AuthException(message)
}
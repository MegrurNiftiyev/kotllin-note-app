package com.example.note_app_kotllin.core.exceptions

sealed class TodoException(override val message: String) : Exception(message) {
    data class ValidationError(override val message: String = "Invalid Todo ID or request body") : TodoException(message)
    data class Unauthorized(override val message: String = "Missing, invalid, or expired token") : TodoException(message)
    data class TodoNotFound(override val message: String = "Todo not found") : TodoException(message)
    data class ServerError(override val message: String = "Something went wrong on server") : TodoException(message)
    data class Unknown(override val message: String = "An unexpected error occurred") : TodoException(message)
}
package com.example.note_app_kotllin.core.exceptions

sealed class NetworkException(override val message: String) : Exception(message) {
    data class NoInternet(override val message: String = "No internet connection") : NetworkException(message)
    data class Timeout(override val message: String = "Connection timed out") : NetworkException(message)
}
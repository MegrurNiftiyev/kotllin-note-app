package com.example.note_app_kotllin.core.exceptions


sealed class NoteException(override val message: String) : Exception(message) {
    data class ValidationError(override val message: String = "Invalid note ID or request body") : NoteException(message)
    data class Unauthorized(override val message: String = "Missing, invalid, or expired token") : NoteException(message)
    data class NoteNotFound(override val message: String = "Note not found") : NoteException(message)
    data class ServerError(override val message: String = "Something went wrong on server") : NoteException(message)
    data class Unknown(override val message: String = "An unexpected error occurred") : NoteException(message)
}
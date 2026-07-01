package com.example.note_app_kotllin.data.datasoruces.remote.services
import com.example.note_app_kotllin.data.models.request.NoteRequest
import com.example.note_app_kotllin.data.models.response.NoteListResponse
import com.example.note_app_kotllin.data.models.response.NoteResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface NoteApiService {

    @GET("/api/notes")
    suspend fun getAllNotes(): NoteListResponse

    @GET("/api/notes/{id}")
    suspend fun getNoteById(@Path("id") id: String): NoteResponse

    @POST("/api/notes")
    suspend fun createNote(@Body noteRequest: NoteRequest): NoteResponse

    @PATCH("/api/notes/{id}")
    suspend fun updateNote(
        @Path("id") id: String,
        @Body noteRequest: NoteRequest
    ): NoteResponse

    @DELETE("/api/notes")
    suspend fun deleteAllNotes(): Unit

    @DELETE("/api/notes/{id}")
    suspend fun deleteNoteById(@Path("id") id: String): Unit
}
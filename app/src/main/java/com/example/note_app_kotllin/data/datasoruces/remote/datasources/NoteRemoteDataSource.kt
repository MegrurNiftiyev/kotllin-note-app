package com.example.note_app_kotllin.data.datasoruces.remote.datasources

import com.example.note_app_kotllin.core.exceptions.NetworkException
import com.example.note_app_kotllin.core.exceptions.NoteException
import com.example.note_app_kotllin.data.datasoruces.remote.services.NoteApiService
import com.example.note_app_kotllin.data.models.request.NoteRequest
import com.example.note_app_kotllin.data.models.response.NoteListResponse
import com.example.note_app_kotllin.data.models.response.NoteResponse
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class NoteRemoteDataSource @Inject constructor(
    private val noteApiService: NoteApiService
) {

    suspend fun getAllNotes(): NoteListResponse {
        return try {
            noteApiService.getAllNotes()
        } catch (e: HttpException) {
            throw when (e.code()) {
                401 -> NoteException.Unauthorized()
                500 -> NoteException.ServerError()
                else -> NoteException.Unknown()
            }
        } catch (e: IOException) {
            android.util.Log.e("NOTE GET_ALL", "Network error — ${e.message}")
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            android.util.Log.e("NOTE GET_ALL", "Unknown — ${e::class.simpleName}: ${e.message}")
            throw NoteException.Unknown()
        }
    }

    suspend fun getNoteById(id: String): NoteResponse {
        return try {
            noteApiService.getNoteById(id)
        } catch (e: HttpException) {
            throw when (e.code()) {
                400 -> NoteException.ValidationError()
                401 -> NoteException.Unauthorized()
                404 -> NoteException.NoteNotFound()
                500 -> NoteException.ServerError()
                else -> NoteException.Unknown()
            }
        } catch (e: IOException) {
            android.util.Log.e("NOTE GET_BY_ID", "Network error — ${e.message}")
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            android.util.Log.e("NOTE GET_BY_ID", "Unknown — ${e::class.simpleName}: ${e.message}")
            throw NoteException.Unknown()
        }
    }

    suspend fun createNote(title: String, content: String): NoteResponse {
        return try {
            noteApiService.createNote(NoteRequest(title, content))
        } catch (e: HttpException) {
            throw when (e.code()) {
                400 -> NoteException.ValidationError()
                401 -> NoteException.Unauthorized()
                500 -> NoteException.ServerError()
                else -> NoteException.Unknown()
            }
        } catch (e: IOException) {
            android.util.Log.e("NOTE CREATE", "Network error — ${e.message}")
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            android.util.Log.e("NOTE CREATE", "Unknown — ${e::class.simpleName}: ${e.message}")
            throw NoteException.Unknown()
        }
    }

    suspend fun updateNote(id: String, title: String, content: String): NoteResponse {
        return try {
            noteApiService.updateNote(id, NoteRequest(title, content))
        } catch (e: HttpException) {
            throw when (e.code()) {
                400 -> NoteException.ValidationError()
                401 -> NoteException.Unauthorized()
                404 -> NoteException.NoteNotFound()
                500 -> NoteException.ServerError()
                else -> NoteException.Unknown()
            }
        } catch (e: IOException) {
            android.util.Log.e("NOTE UPDATE", "Network error — ${e.message}")
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            android.util.Log.e("NOTE UPDATE", "Unknown — ${e::class.simpleName}: ${e.message}")
            throw NoteException.Unknown()
        }
    }

    suspend fun deleteAllNotes() {
        try {
            noteApiService.deleteAllNotes()
        } catch (e: HttpException) {
            throw when (e.code()) {
                401 -> NoteException.Unauthorized()
                500 -> NoteException.ServerError()
                else -> NoteException.Unknown()
            }
        } catch (e: IOException) {
            android.util.Log.e("NOTE DELETE_ALL", "Network error — ${e.message}")
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            android.util.Log.e("NOTE DELETE_ALL", "Unknown — ${e::class.simpleName}: ${e.message}")
            throw NoteException.Unknown()
        }
    }

    suspend fun deleteNoteById(id: String) {
        try {
            noteApiService.deleteNoteById(id)
        } catch (e: HttpException) {
            throw when (e.code()) {
                400 -> NoteException.ValidationError()
                401 -> NoteException.Unauthorized()
                404 -> NoteException.NoteNotFound()
                500 -> NoteException.ServerError()
                else -> NoteException.Unknown()
            }
        } catch (e: IOException) {
            android.util.Log.e("NOTE DELETE_BY_ID", "Network error — ${e.message}")
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            android.util.Log.e("NOTE DELETE_BY_ID", "Unknown — ${e::class.simpleName}: ${e.message}")
            throw NoteException.Unknown()
        }
    }
}
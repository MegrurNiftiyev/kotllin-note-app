package com.example.note_app_kotllin.data.datasoruces.remote.datasources

import com.example.note_app_kotllin.core.exceptions.AuthException
import com.example.note_app_kotllin.core.exceptions.NetworkException
import com.example.note_app_kotllin.core.exceptions.UserException
import com.example.note_app_kotllin.data.datasoruces.remote.services.UserApiService
import com.example.note_app_kotllin.data.models.request.UpdateUserRequest
import com.example.note_app_kotllin.data.models.response.UserResponse
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    val userApiService: UserApiService
) {

    suspend fun getUser(): UserResponse {
        return try {
            userApiService.getUser()
        } catch (e: HttpException) {
            throw when (e.code()) {
                401 -> UserException.Unauthorized()
                404 -> UserException.UserNotFound()
                500 -> UserException.ServerError()
                else -> UserException.Unknown()
            }
        } catch (e: IOException) {
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            throw AuthException.Unknown()
        }
    }

    suspend fun updateUser(userName: String, email: String): UserResponse {
        return try {
            userApiService.updateUser(UpdateUserRequest(userName, email))

        } catch (e: HttpException) {
            throw when (e.code()) {
                400 -> UserException.ValidationError()
                401 -> UserException.Unauthorized()
                404 -> UserException.UserNotFound()
                409 -> UserException.EmailAlreadyRegistered()
                500 -> UserException.ServerError()
                else -> UserException.Unknown()
            }
        } catch (e: IOException) {
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            throw AuthException.Unknown()
        }


    }

    suspend fun deleteUser(): UserResponse {
        return try {
            userApiService.deleteUser()
        } catch (e: HttpException) {
            throw when (e.code()) {
                401 -> UserException.Unauthorized()
                404 -> UserException.UserNotFound()
                500 -> UserException.ServerError()
                else -> UserException.Unknown()
            }
        } catch (e: IOException) {
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            throw AuthException.Unknown()
        }
    }
}
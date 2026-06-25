package com.example.note_app_kotllin.data.datasoruces.remote.datasources

import com.example.note_app_kotllin.core.exceptions.AuthException
import com.example.note_app_kotllin.core.exceptions.NetworkException
import com.example.note_app_kotllin.data.datasoruces.remote.services.AuthApiService
import com.example.note_app_kotllin.data.models.request.LoginRequest
import com.example.note_app_kotllin.data.models.request.LogoutRequest
import com.example.note_app_kotllin.data.models.request.RefreshRequest
import com.example.note_app_kotllin.data.models.request.RegisterRequest
import com.example.note_app_kotllin.data.models.response.LoginResponse
import com.example.note_app_kotllin.data.models.response.RefreshResponse
import com.example.note_app_kotllin.data.models.response.RegisterResponse
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApiService: AuthApiService
) {

    suspend fun register(userName: String, email: String, password: String): RegisterResponse {
        return try {
            authApiService.register(RegisterRequest(userName, email, password))

        } catch (e: HttpException) {
            throw when (e.code()) {
                409 -> AuthException.EmailAlreadyExists()
                400 -> AuthException.ValidationError()
                429 -> AuthException.TooManyRequests()
                500 -> AuthException.ServerError()
                else -> AuthException.Unknown()
            }
        } catch (e: IOException) {
            android.util.Log.e("REGISTER", "Network error — ${e.message}")
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            android.util.Log.e("REGISTER", "Unknown — ${e::class.simpleName}: ${e.message}")
            throw AuthException.Unknown()
        }
    }

    suspend fun login(email: String, password: String): LoginResponse {
        return try {
            authApiService.login(LoginRequest(email, password))

        } catch (e: HttpException) {
            throw when (e.code()) {
                401 -> AuthException.InvalidCredentials()
                400 -> AuthException.ValidationError()
                429 -> AuthException.TooManyRequests()
                else -> AuthException.Unknown()
            }
        } catch (e: IOException) {
            android.util.Log.e("LOGIN", "Network error — ${e.message}")
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            android.util.Log.e("LOGIN", "Unknown — ${e::class.simpleName}: ${e.message}")
            throw AuthException.Unknown()
        }

    }

    suspend fun refresh(refreshToken: String): RefreshResponse {
        return try {
            authApiService.refresh(RefreshRequest(refreshToken))

        } catch (e: HttpException) {
            throw when (e.code()) {
                401 -> AuthException.InvalidRefreshToken()
                429 -> AuthException.TooManyRequests()
                else -> AuthException.Unknown()
            }
        } catch (e: IOException) {
            android.util.Log.e("REFRESH", "Network error — ${e.message}")
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            android.util.Log.e("REFRESH", "Unknown — ${e::class.simpleName}: ${e.message}")
            throw AuthException.Unknown()
        }
    }

    suspend fun logout(refreshToken: String) {
        return try {
            authApiService.logout(LogoutRequest(refreshToken))
        } catch (e: HttpException) {
            throw when (e.code()) {
                401 -> AuthException.InvalidRefreshToken()
                429 -> AuthException.TooManyRequests()
                else -> AuthException.Unknown()
            }
        } catch (e: IOException) {
            android.util.Log.e("LOGOUT", "Network error — ${e.message}")
            throw NetworkException.NoInternet()
        } catch (e: Exception) {
            android.util.Log.e("LOGOUT", "Unknown — ${e::class.simpleName}: ${e.message}")
            throw AuthException.Unknown()
        }
    }
}

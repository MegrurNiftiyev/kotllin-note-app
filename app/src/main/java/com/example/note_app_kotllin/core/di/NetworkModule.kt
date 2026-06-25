package com.example.note_app_kotllin.core.di

import com.example.note_app_kotllin.core.constants.ApiUrls
import com.example.note_app_kotllin.core.interceptors.AuthInterceptor
import com.example.note_app_kotllin.core.interceptors.TokenAuthenticator
import com.example.note_app_kotllin.data.datasoruces.remote.services.AuthApiService
import com.example.note_app_kotllin.data.datasoruces.remote.services.NoteApiService
import com.example.note_app_kotllin.data.datasoruces.remote.services.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    private val json = Json { ignoreUnknownKeys = true }
    private val contentType = "application/json".toMediaType()


    @Provides
    @Singleton
    @Named("AuthOkHttpClient")
    fun provideAuthOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    @Named("NormalOkHttpClient")
    fun provideNormalOkHttpClient(
        authInterceptor: AuthInterceptor,
        tokenAuthenticator: TokenAuthenticator
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .authenticator(tokenAuthenticator)
            .build()
    }


    @Provides
    @Singleton
    @Named("AuthRetrofit")
    fun provideAuthRetrofit(
        @Named("AuthOkHttpClient") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiUrls.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    @Named("AppRetrofit")
    fun provideAppRetrofit(
        @Named("NormalOkHttpClient") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiUrls.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }
    //connections

    @Provides
    @Singleton
    fun  provideAuthApiService(@Named("AppRetrofit") retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)

    }

    @Provides
    @Singleton
    fun provideNoteApiService(@Named("AppRetrofit") retrofit: Retrofit): NoteApiService {

        return retrofit.create(NoteApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserApiService(@Named("AppRetrofit") retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }


}
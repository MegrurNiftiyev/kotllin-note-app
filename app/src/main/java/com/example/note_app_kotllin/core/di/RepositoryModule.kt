package com.example.note_app_kotllin.core.di

import com.example.note_app_kotllin.data.repostories.AuthRepository
import com.example.note_app_kotllin.data.repostories.SettingsRepository
import com.example.note_app_kotllin.domain.repositories.IAuthRepository
import com.example.note_app_kotllin.domain.repositories.ISettingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSettingsRepository(
        impl: SettingsRepository
    ): ISettingsRepository


    @Binds
    abstract  fun bindAuthRepository(
        impl: AuthRepository
    ): IAuthRepository

}
package com.example.note_app_kotllin.core.di

import com.example.note_app_kotllin.data.repostories.SettingsRepository
import com.example.note_app_kotllin.data.repostories.interfaces.ISettingsRepository
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

}
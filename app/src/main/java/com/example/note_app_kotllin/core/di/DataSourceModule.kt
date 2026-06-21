package com.example.note_app_kotllin.core.di

import com.example.note_app_kotllin.data.datasoruces.local.SettingsLocalDataSource
import com.example.note_app_kotllin.data.datasoruces.local.interfaces.ISettingsLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindSettingsLocalDataSource(
        impl: SettingsLocalDataSource
    ): ISettingsLocalDataSource

}
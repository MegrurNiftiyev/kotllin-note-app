package com.example.note_app_kotllin.core.di

import android.content.Context
import androidx.room.Room
import com.example.note_app_kotllin.core.constants.CacheKeys
import com.example.note_app_kotllin.data.datasoruces.local.room.AppDatabase
import com.example.note_app_kotllin.data.datasoruces.local.room.daos.NoteDao
import com.example.note_app_kotllin.data.datasoruces.local.room.daos.TodoDao
import com.example.note_app_kotllin.data.datasoruces.local.room.daos.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context, AppDatabase::class.java, CacheKeys.ROOM_DATABASE
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    @Singleton
    fun provideNoteDao(database: AppDatabase): NoteDao {
        return database.noteDao()
    }

    @Provides
    @Singleton
    fun provideTodoDao(database: AppDatabase): TodoDao {
        return database.todoDao()
    }

}
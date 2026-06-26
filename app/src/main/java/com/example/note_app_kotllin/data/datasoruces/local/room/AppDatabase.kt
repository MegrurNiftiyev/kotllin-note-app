package com.example.note_app_kotllin.data.datasoruces.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.note_app_kotllin.data.datasoruces.local.room.daos.NoteDao
import com.example.note_app_kotllin.data.datasoruces.local.room.daos.TodoDao
import com.example.note_app_kotllin.data.datasoruces.local.room.daos.UserDao
import com.example.note_app_kotllin.data.datasoruces.local.room.entities.UserEntity
import com.example.note_app_kotllin.data.datasoruces.local.room.entities.NoteEntity
import com.example.note_app_kotllin.data.datasoruces.local.room.entities.TodoEntity

@Database(
    entities = [UserEntity::class,NoteEntity::class,TodoEntity::class],
    version = 1,
    exportSchema = false

)

abstract class AppDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun noteDao(): NoteDao
    abstract fun todoDao(): TodoDao

}
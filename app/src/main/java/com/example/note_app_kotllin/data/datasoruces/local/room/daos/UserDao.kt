package com.example.note_app_kotllin.data.datasoruces.local.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.note_app_kotllin.data.datasoruces.local.room.entities.UserEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM User LIMIT 1")
   suspend fun getUser(): UserEntity?

    @Query("DELETE FROM User")
   suspend fun clearUser()
}

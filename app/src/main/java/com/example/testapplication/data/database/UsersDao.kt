package com.example.testapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testapplication.data.datasource.local.model.UserDbModel

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: UserDbModel)

    @Query("SELECT * FROM users_auth_data WHERE firstName=:firstName")
    fun getUser(firstName: String): UserDbModel?
}
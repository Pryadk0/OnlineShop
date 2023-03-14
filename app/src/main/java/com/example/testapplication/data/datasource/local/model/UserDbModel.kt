package com.example.testapplication.data.datasource.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_auth_data")
data class UserDbModel(
    @PrimaryKey
    val firstName: String,
    val lastName: String,
    val email: String
)
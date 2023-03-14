package com.example.testapplication.data.datasource.local

import com.example.testapplication.domain.User

interface LocalDataSource {

    fun getUserFromDb(firstName: String): User?

    fun writeUserInDb(user: User)
}
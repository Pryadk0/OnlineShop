package com.example.testapplication.features.authentication.domain

import com.example.testapplication.features.authentication.domain.entities.User


interface AuthenticationRepository {

    fun getUserFormDb(firstName: String): User?

    fun writeUserInDb(user: User)
}
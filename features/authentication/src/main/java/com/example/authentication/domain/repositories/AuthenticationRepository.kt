package com.example.authentication.domain.repositories

import com.example.authentication.domain.entities.User


interface AuthenticationRepository {

    fun getUserFormDb(firstName: String): User?

    fun writeUserInDb(user: User)
}
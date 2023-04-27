package com.example.authentication

import com.example.authentication.entities.UserDataEntity

interface AuthenticationDataRepository {

    fun getUserFormDb(firstName: String): UserDataEntity?

    fun writeUserInDb(userDataEntity: UserDataEntity)
}
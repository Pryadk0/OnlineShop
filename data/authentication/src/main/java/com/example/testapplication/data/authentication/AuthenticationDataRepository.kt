package com.example.testapplication.data.authentication

import com.example.testapplication.data.authentication.entities.UserDataEntity

interface AuthenticationDataRepository {

    fun getUserFormDb(firstName: String): UserDataEntity?

    fun writeUserInDb(userDataEntity: UserDataEntity)
}
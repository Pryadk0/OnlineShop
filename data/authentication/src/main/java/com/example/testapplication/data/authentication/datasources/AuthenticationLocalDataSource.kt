package com.example.testapplication.data.authentication.datasources

import com.example.testapplication.data.authentication.entities.UserDataEntity

interface AuthenticationLocalDataSource {

    fun getUserFromDb(firstName: String): UserDataEntity?

    fun writeUserInDb(userDataEntity: UserDataEntity)
}
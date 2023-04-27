package com.example.authentication.datasources

import com.example.authentication.entities.UserDataEntity

interface AuthenticationLocalDataSource {

    fun getUserFromDb(firstName: String): UserDataEntity?

    fun writeUserInDb(userDataEntity: UserDataEntity)
}
package com.example.testapplication.features.authentication.domain.usecases

import com.example.testapplication.features.authentication.domain.entities.User

internal interface GetUserFromDbUseCase {

    fun getUserFormDb(firstName: String): User?

}
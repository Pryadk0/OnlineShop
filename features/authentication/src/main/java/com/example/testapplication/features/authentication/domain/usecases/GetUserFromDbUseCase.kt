package com.example.testapplication.features.authentication.domain.usecases

import com.example.testapplication.features.authentication.domain.entities.User
import com.example.testapplication.features.authentication.domain.AuthenticationRepository
import javax.inject.Inject

class GetUserFromDbUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    fun getUserFormDb(firstName: String): User? = repository.getUserFormDb(firstName)
}
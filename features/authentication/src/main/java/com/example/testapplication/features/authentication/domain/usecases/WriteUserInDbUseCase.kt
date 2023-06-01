package com.example.testapplication.features.authentication.domain.usecases

import com.example.testapplication.features.authentication.domain.entities.User
import com.example.testapplication.features.authentication.domain.AuthenticationRepository
import javax.inject.Inject

internal class WriteUserInDbUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    fun writeUserInDb(user: User) = repository.writeUserInDb(user)

}
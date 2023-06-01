package com.example.testapplication.features.authentication.domain.usecases.impl

import com.example.testapplication.features.authentication.domain.entities.User
import com.example.testapplication.features.authentication.domain.AuthenticationRepository
import com.example.testapplication.features.authentication.domain.usecases.WriteUserInDbUseCase
import javax.inject.Inject

internal class WriteUserInDbUseCaseImpl @Inject constructor(
    private val repository: AuthenticationRepository
): WriteUserInDbUseCase {

    override fun writeUserInDb(user: User) = repository.writeUserInDb(user)

}
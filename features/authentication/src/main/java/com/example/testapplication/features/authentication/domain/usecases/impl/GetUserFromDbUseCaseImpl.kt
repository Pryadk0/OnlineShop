package com.example.testapplication.features.authentication.domain.usecases.impl

import com.example.testapplication.features.authentication.domain.entities.User
import com.example.testapplication.features.authentication.domain.AuthenticationRepository
import com.example.testapplication.features.authentication.domain.usecases.GetUserFromDbUseCase
import javax.inject.Inject

internal class GetUserFromDbUseCaseImpl @Inject constructor(
    private val repository: AuthenticationRepository
): GetUserFromDbUseCase {

    override fun getUserFormDb(firstName: String): User? = repository.getUserFormDb(firstName)

}
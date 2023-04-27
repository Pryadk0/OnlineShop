package com.example.authentication.domain.usecases

import com.example.authentication.domain.entities.User
import com.example.authentication.domain.repositories.AuthenticationRepository
import javax.inject.Inject

class GetUserFromDbUseCase @Inject constructor(private val repository: AuthenticationRepository) {

    fun getUserFormDb(firstName: String): User? = repository.getUserFormDb(firstName)
}
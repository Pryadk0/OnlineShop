package com.example.authentication.domain.usecases

import com.example.authentication.domain.entities.User
import com.example.authentication.domain.AuthenticationRepository
import javax.inject.Inject

class WriteUserInDbUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {

    fun writeUserInDb(user: User) = repository.writeUserInDb(user)

}
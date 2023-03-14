package com.example.testapplication.domain

import javax.inject.Inject

class WriteUserInDbUseCase @Inject constructor(private val repository: Repository) {

    fun writeUserInDb(user: User) = repository.writeUserInDb(user)

}
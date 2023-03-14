package com.example.testapplication.domain

import javax.inject.Inject

class GetUserFromDbUseCase @Inject constructor(private val repository: Repository) {

    fun getUserFormDb(firstName: String): User? = repository.getUserFormDb(firstName)
}
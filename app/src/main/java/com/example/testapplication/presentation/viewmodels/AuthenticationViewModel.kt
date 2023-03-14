package com.example.testapplication.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.testapplication.domain.GetUserFromDbUseCase
import com.example.testapplication.domain.User
import com.example.testapplication.domain.WriteUserInDbUseCase
import javax.inject.Inject

class AuthenticationViewModel @Inject constructor(
    private val getUserFromDbUseCase: GetUserFromDbUseCase,
    private val writeUserInDbUseCase: WriteUserInDbUseCase
) : ViewModel() {

    fun getUserFormDb(firstName: String): User? = getUserFromDbUseCase.getUserFormDb(firstName)

    fun writeUserInDb(firstName: String, lastName: String, email: String) =
        writeUserInDbUseCase.writeUserInDb(User(firstName, lastName, email))
}
package com.example.testapplication.features.authentication.presentation.login

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.testapplication.features.authentication.LogInRouter
import com.example.testapplication.features.authentication.domain.entities.User
import com.example.testapplication.features.authentication.domain.usecases.GetUserFromDbUseCase
import javax.inject.Inject

class LogInViewModel @Inject constructor(
    private val getUserFromDbUseCase: GetUserFromDbUseCase,
    private val logInRouter: LogInRouter
) : ViewModel() {

    fun getUserFormDb(firstName: String): User? = getUserFromDbUseCase.getUserFormDb(firstName)

    fun startAuthorizedScreen(fromFragment: Fragment) = logInRouter.startAuthorizedScreen(fromFragment)
}
package com.example.authentication.presentation.login

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.authentication.LogInRouter
import com.example.authentication.domain.entities.User
import com.example.authentication.domain.usecases.GetUserFromDbUseCase
import javax.inject.Inject

class LogInViewModel @Inject constructor(
    private val getUserFromDbUseCase: GetUserFromDbUseCase,
    private val logInRouter: LogInRouter
) : ViewModel() {

    fun getUserFormDb(firstName: String): User? = getUserFromDbUseCase.getUserFormDb(firstName)

    fun startAuthorizedScreen(fromFragment: Fragment) = logInRouter.startAuthorizedScreen(fromFragment)
}
package com.example.testapplication.features.authentication.presentation.signin

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.testapplication.features.authentication.SignInRouter
import com.example.testapplication.features.authentication.domain.entities.User
import com.example.testapplication.features.authentication.domain.usecases.GetUserFromDbUseCase
import com.example.testapplication.features.authentication.domain.usecases.WriteUserInDbUseCase
import javax.inject.Inject

internal class SignInPageViewModel @Inject constructor(
    private val getUserFromDbUseCase: GetUserFromDbUseCase,
    private val writeUserInDbUseCase: WriteUserInDbUseCase,
    private val signInRouter: SignInRouter
) : ViewModel() {

    fun getUserFormDb(firstName: String): User? = getUserFromDbUseCase.getUserFormDb(firstName)

    fun writeUserInDb(firstName: String, lastName: String, email: String) =
        writeUserInDbUseCase.writeUserInDb(User(firstName, lastName, email))

    fun startSignInScreen(fromFragment: Fragment) =
        signInRouter.startLogInScreen(fromFragment)

    fun startAuthorizedScreen(fromFragment: Fragment) =
        signInRouter.startAuthorizedScreen(fromFragment)

}
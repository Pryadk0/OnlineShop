package com.example.testapplication.glue.authentication

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testapplication.features.authentication.SignInRouter
import com.example.testapplication.features.authentication.presentation.signin.SignInPageFragmentDirections

import javax.inject.Inject

internal class SignInRouterImpl @Inject constructor() : SignInRouter {

    override fun startLogInScreen(fromFragment: Fragment) {
        fromFragment.findNavController()
            .navigate(SignInPageFragmentDirections.actionSignInPageFragmentToLogInFragment())
    }

    override fun startAuthorizedScreen(fromFragment: Fragment) {
        fromFragment.findNavController()
            .navigate(SignInPageFragmentDirections.actionSignInPageFragmentToAuthorizedActivity())

    }
}
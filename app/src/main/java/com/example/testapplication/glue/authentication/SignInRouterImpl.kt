package com.example.testapplication.glue.authentication

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.authentication.SignInRouter
import com.example.testapplication.presentation.fragments.SignInPageFragmentDirections
import javax.inject.Inject

class SignInRouterImpl @Inject constructor() : SignInRouter {

    override fun startLogInScreen(fromFragment: Fragment) {
        fromFragment.findNavController()
            .navigate(SignInPageFragmentDirections.actionSignInPageFragmentToLogInFragment())
    }

    override fun startAuthorizedScreen(fromFragment: Fragment) {
        fromFragment.findNavController()
            .navigate(SignInPageFragmentDirections.actionSignInPageFragmentToAuthorizedActivity())

    }
}
package com.example.testapplication.glue.authentication

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.testapplication.features.authentication.LogInRouter
import com.example.testapplication.features.authentication.presentation.login.LogInFragmentDirections
import javax.inject.Inject

class LogInRouterImpl @Inject constructor() : LogInRouter {

    override fun startAuthorizedScreen(fromFragment: Fragment) =
        fromFragment.findNavController()
            .navigate(LogInFragmentDirections.actionLogInFragmentToAuthorizedActivity())


}
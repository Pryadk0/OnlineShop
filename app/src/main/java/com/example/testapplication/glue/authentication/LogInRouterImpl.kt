package com.example.testapplication.glue.authentication

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.authentication.LogInRouter
import com.example.testapplication.presentation.fragments.LogInFragmentDirections

class LogInRouterImpl : LogInRouter {

    override fun startAuthorizedScreen(fromFragment: Fragment) =
        fromFragment.findNavController()
            .navigate(LogInFragmentDirections.actionLogInFragmentToAuthorizedActivity())


}
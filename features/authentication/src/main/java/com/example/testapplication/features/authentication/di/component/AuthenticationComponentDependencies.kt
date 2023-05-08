package com.example.testapplication.features.authentication.di.component

import com.example.testapplication.features.authentication.LogInRouter
import com.example.testapplication.features.authentication.SignInRouter
import com.example.testapplication.features.authentication.domain.AuthenticationRepository

interface AuthenticationComponentDependencies {

    fun getLogInRouter(): LogInRouter

    fun getSignInRouter(): SignInRouter

    fun getAuthenticationRepository(): AuthenticationRepository
}
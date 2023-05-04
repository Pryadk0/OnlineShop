package com.example.authentication.di.component

import com.example.authentication.LogInRouter
import com.example.authentication.SignInRouter
import com.example.authentication.domain.AuthenticationRepository

interface AuthenticationComponentDependencies {

    fun getLogInRouter(): LogInRouter

    fun getSignInRouter(): SignInRouter

    fun getAuthenticationRepository(): AuthenticationRepository
}
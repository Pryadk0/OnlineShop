package com.example.testapplication.glue.authentication.di

import com.example.testapplication.data.authentication.AuthenticationDataRepository
import com.example.testapplication.data.authentication.AuthenticationDataRepositoryImpl
import com.example.testapplication.data.authentication.datasources.AuthenticationLocalDataSource
import com.example.testapplication.data.authentication.datasources.local.AuthenticationLocalDataSourceImpl
import com.example.testapplication.features.authentication.LogInRouter
import com.example.testapplication.features.authentication.SignInRouter
import com.example.testapplication.features.authentication.domain.AuthenticationRepository
import com.example.testapplication.glue.authentication.LogInRouterImpl
import com.example.testapplication.glue.authentication.SignInRouterImpl
import com.example.testapplication.glue.authentication.repositories.AuthenticationRepositoryAdapter
import dagger.Binds
import dagger.Module

@Module
internal interface AuthenticationModule {

    @Binds
    fun bindLogInRouter(impl: LogInRouterImpl): LogInRouter

    @Binds
    fun bindSignInRouter(impl: SignInRouterImpl): SignInRouter

    @Binds
    fun bindAuthenticationRepository(impl: AuthenticationRepositoryAdapter): AuthenticationRepository

    @Binds
    fun bindAuthenticationDataRepository(impl: AuthenticationDataRepositoryImpl): AuthenticationDataRepository

    @Binds
    fun bindAuthenticationLocalDataSource(impl: AuthenticationLocalDataSourceImpl): AuthenticationLocalDataSource
}
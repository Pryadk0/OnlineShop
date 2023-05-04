package com.example.testapplication.glue.authentication.di

import com.example.authentication.AuthenticationDataRepository
import com.example.authentication.AuthenticationDataRepositoryImpl
import com.example.authentication.LogInRouter
import com.example.authentication.SignInRouter
import com.example.authentication.datasources.AuthenticationLocalDataSource
import com.example.authentication.datasources.local.AuthenticationLocalDataSourceImpl
import com.example.authentication.di.scopes.AuthenticationFeatureScope
import com.example.authentication.domain.AuthenticationRepository
import com.example.testapplication.glue.authentication.LogInRouterImpl
import com.example.testapplication.glue.authentication.SignInRouterImpl
import com.example.testapplication.glue.authentication.repositories.AuthenticationRepositoryAdapter
import dagger.Binds
import dagger.Module

@Module
interface AuthenticationModule {

    @AuthenticationFeatureScope
    @Binds
    fun bindLogInRouter(impl: LogInRouterImpl): LogInRouter

    @AuthenticationFeatureScope
    @Binds
    fun bindSignInRouter(impl: SignInRouterImpl): SignInRouter

    @AuthenticationFeatureScope
    @Binds
    fun bindAuthenticationRepository(impl: AuthenticationRepositoryAdapter): AuthenticationRepository

    //AuthenticationDataBindings:
    @AuthenticationFeatureScope
    @Binds
    fun bindAuthenticationDataRepository(impl: AuthenticationDataRepositoryImpl): AuthenticationDataRepository

    @AuthenticationFeatureScope
    @Binds
    fun bindAuthenticationLocalDataSource(impl: AuthenticationLocalDataSourceImpl): AuthenticationLocalDataSource
}
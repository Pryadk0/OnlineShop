package com.example.testapplication.data.authentication.di

import com.example.testapplication.data.authentication.AuthenticationDataRepository
import com.example.testapplication.data.authentication.AuthenticationDataRepositoryImpl
import com.example.testapplication.data.authentication.datasources.AuthenticationLocalDataSource
import com.example.testapplication.data.authentication.datasources.local.AuthenticationLocalDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface AuthenticationDataModule {

    @Binds
    fun bindAuthenticationDataRepository(impl: AuthenticationDataRepositoryImpl): AuthenticationDataRepository


    @Binds
    fun bindAuthenticationLocalDataSource(impl: AuthenticationLocalDataSourceImpl): AuthenticationLocalDataSource


}
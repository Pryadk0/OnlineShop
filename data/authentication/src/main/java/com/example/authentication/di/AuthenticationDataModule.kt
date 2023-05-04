package com.example.authentication.di

import com.example.authentication.AuthenticationDataRepository
import com.example.authentication.AuthenticationDataRepositoryImpl
import com.example.authentication.datasources.AuthenticationLocalDataSource
import com.example.authentication.datasources.local.AuthenticationLocalDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface AuthenticationDataModule {

    @Binds
    fun bindAuthenticationDataRepository(impl: AuthenticationDataRepositoryImpl): AuthenticationDataRepository


    @Binds
    fun bindAuthenticationLocalDataSource(impl: AuthenticationLocalDataSourceImpl): AuthenticationLocalDataSource


}
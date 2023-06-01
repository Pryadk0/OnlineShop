package com.example.testapplication.features.authentication.di.modules

import com.example.testapplication.features.authentication.domain.usecases.GetUserFromDbUseCase
import com.example.testapplication.features.authentication.domain.usecases.impl.GetUserFromDbUseCaseImpl
import com.example.testapplication.features.authentication.domain.usecases.WriteUserInDbUseCase
import com.example.testapplication.features.authentication.domain.usecases.impl.WriteUserInDbUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface AuthenticationUseCaseModule {

    @Binds
    fun bindGetUserFromDbUseCase(impl: GetUserFromDbUseCaseImpl): GetUserFromDbUseCase

    @Binds
    fun bindWriteUserInDbUseCase(impl: WriteUserInDbUseCaseImpl): WriteUserInDbUseCase

}
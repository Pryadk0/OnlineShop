package com.example.testapplication.di.modules

import com.example.testapplication.data.repository.RepositoryImpl
import com.example.testapplication.di.scopes.ApplicationScope
import com.example.testapplication.domain.Repository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository
}
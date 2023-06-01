package com.example.testapplication.glue.page1.di

import com.example.testapplication.data.page1.Page1DataRepository
import com.example.testapplication.data.page1.Page1DataRepositoryImpl
import com.example.testapplication.features.page1.Page1Router
import com.example.testapplication.data.page1.datasources.Page1RemoteDataSource
import com.example.testapplication.data.page1.datasources.remote.Page1RemoteDataSourceImpl
import com.example.testapplication.features.page1.domain.Page1Repository
import com.example.testapplication.glue.page1.Page1RouterImpl
import com.example.testapplication.glue.page1.repositories.Page1RepositoryAdapter
import dagger.Binds
import dagger.Module

@Module
internal interface Page1Module {

    @Binds
    fun bindPage1Router(impl: Page1RouterImpl): Page1Router

    @Binds
    fun bindPageRepository(impl: Page1RepositoryAdapter): Page1Repository

    @Binds
    fun bindPage1DataRepository(impl: Page1DataRepositoryImpl): Page1DataRepository

    @Binds
    fun bindPage1RemoteDataSource(impl: Page1RemoteDataSourceImpl): Page1RemoteDataSource

}
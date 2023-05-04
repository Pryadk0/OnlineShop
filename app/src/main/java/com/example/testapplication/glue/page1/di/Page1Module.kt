package com.example.testapplication.glue.page1.di

import com.example.page1.Page1DataRepository
import com.example.page1.Page1DataRepositoryImpl
import com.example.page1.Page1Router
import com.example.page1.datasources.Page1RemoteDataSource
import com.example.page1.datasources.remote.Page1RemoteDataSourceImpl
import com.example.page1.di.scope.Page1FeatureScope
import com.example.page1.domain.Page1Repository
import com.example.testapplication.glue.page1.Page1RouterImpl
import com.example.testapplication.glue.page1.repositories.Page1RepositoryAdapter
import dagger.Binds
import dagger.Module

@Module
interface Page1Module {

    @Page1FeatureScope
    @Binds
    fun bindPage1Router(impl: Page1RouterImpl): Page1Router

    @Page1FeatureScope
    @Binds
    fun bindPageRepository(impl: Page1RepositoryAdapter): Page1Repository

    @Page1FeatureScope
    @Binds
    fun bindPage1DataRepository(impl: Page1DataRepositoryImpl): Page1DataRepository

    @Page1FeatureScope
    @Binds
    fun bindPage1RemoteDataSource(impl: Page1RemoteDataSourceImpl): Page1RemoteDataSource

}
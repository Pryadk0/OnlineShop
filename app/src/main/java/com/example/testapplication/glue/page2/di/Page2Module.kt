package com.example.testapplication.glue.page2.di

import com.example.testapplication.data.page2.Page2DataRepository
import com.example.testapplication.data.page2.Page2DataRepositoryImpl
import com.example.testapplication.data.page2.datasources.Page2RemoteDataSource
import com.example.testapplication.data.page2.datasources.remote.Page2RemoteDataSourceImpl
import com.example.testapplication.features.page2.Page2Router
import com.example.testapplication.features.page2.domain.Page2Repository
import com.example.testapplication.glue.page2.Page2RouterImpl
import com.example.testapplication.glue.page2.repositories.Page2RepositoryAdapter
import dagger.Binds
import dagger.Module

@Module
internal interface Page2Module {

    @Binds
    fun bindPage2Router(impl: Page2RouterImpl): Page2Router

    @Binds
    fun bindPage2Repository(impl: Page2RepositoryAdapter): Page2Repository

    @Binds
    fun bindPage2DataRepository(impl: Page2DataRepositoryImpl): Page2DataRepository

    @Binds
    fun bindPage2RemoteDataSource(impl: Page2RemoteDataSourceImpl): Page2RemoteDataSource

}
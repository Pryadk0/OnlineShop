package com.example.testapplication.glue.page2.di

import com.example.testapplication.data.page2.Page2DataRepository
import com.example.testapplication.data.page2.Page2DataRepositoryImpl
import com.example.testapplication.features.page2.Page2Router
import com.example.testapplication.data.page2.ProductImageDataRepository
import com.example.testapplication.data.page2.ProductImageDataRepositoryImpl
import com.example.testapplication.data.page2.datasources.Page2RemoteDataSource
import com.example.testapplication.data.page2.datasources.ProductImageRemoteDataSource
import com.example.testapplication.data.page2.datasources.remote.Page2RemoteDataSourceImpl
import com.example.testapplication.data.page2.datasources.remote.ProductImageRemoteDataSourceImpl
import com.example.testapplication.features.page2.domain.Page2Repository
import com.example.testapplication.features.page2.domain.ProductImageRepository
import com.example.testapplication.glue.page2.Page2RouterImpl
import com.example.testapplication.glue.page2.repositories.Page2RepositoryAdapter
import com.example.testapplication.glue.page2.repositories.ProductImageRepositoryAdapter
import dagger.Binds
import dagger.Module

@Module
interface Page2Module {


    @Binds
    fun bindPage2Router(impl: Page2RouterImpl): Page2Router


    @Binds
    fun bindProductImageRepository(impl: ProductImageRepositoryAdapter): ProductImageRepository

    //ProductImageDataBindings:
    @Binds
    fun bindProductImageDataRepository(impl: ProductImageDataRepositoryImpl): ProductImageDataRepository

    @Binds
    fun bindProductImageRemoteDataSource(impl: ProductImageRemoteDataSourceImpl): ProductImageRemoteDataSource

    //Page2Bindings:

    @Binds
    fun bindPage2Repository(impl: Page2RepositoryAdapter): Page2Repository

    //Page2DataBindings:
    @Binds
    fun bindPage2DataRepository(impl: Page2DataRepositoryImpl): Page2DataRepository

    @Binds
    fun bindPage2RemoteDataSource(impl: Page2RemoteDataSourceImpl): Page2RemoteDataSource

}
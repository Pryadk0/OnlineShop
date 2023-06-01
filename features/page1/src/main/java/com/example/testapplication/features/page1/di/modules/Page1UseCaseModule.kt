package com.example.testapplication.features.page1.di.modules

import com.example.testapplication.features.page1.domain.usecases.DownloadProductImageUseCase
import com.example.testapplication.features.page1.domain.usecases.GetAllProductsUseCase
import com.example.testapplication.features.page1.domain.usecases.GetSearchWordsUseCase
import com.example.testapplication.features.page1.domain.usecases.impl.DownloadProductImageUseCaseImpl
import com.example.testapplication.features.page1.domain.usecases.impl.GetAllProductsUseCaseImpl
import com.example.testapplication.features.page1.domain.usecases.impl.GetSearchWordsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface Page1UseCaseModule {

    @Binds
    fun bindDownloadProductImageUseCase(impl: DownloadProductImageUseCaseImpl): DownloadProductImageUseCase

    @Binds
    fun bindGetAllProductsUseCase(impl: GetAllProductsUseCaseImpl): GetAllProductsUseCase

    @Binds
    fun bindGetSearchWordsUseCase(impl: GetSearchWordsUseCaseImpl): GetSearchWordsUseCase

}
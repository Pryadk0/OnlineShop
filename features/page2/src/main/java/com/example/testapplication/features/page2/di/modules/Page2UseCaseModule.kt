package com.example.testapplication.features.page2.di.modules

import com.example.testapplication.features.page2.domain.usecases.DownloadProductImageUseCase
import com.example.testapplication.features.page2.domain.usecases.GetProductDetailInfoUseCase
import com.example.testapplication.features.page2.domain.usecases.impl.DownloadProductImageUseCaseImpl
import com.example.testapplication.features.page2.domain.usecases.impl.GetProductDetailInfoUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface Page2UseCaseModule {

    @Binds
    fun bindDownloadProductImageUseCase(impl: DownloadProductImageUseCaseImpl): DownloadProductImageUseCase

    @Binds
    fun bindGetProductDetailInfoUseCase(impl: GetProductDetailInfoUseCaseImpl): GetProductDetailInfoUseCase

}
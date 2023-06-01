package com.example.testapplication.features.page2.di.modules

import com.example.testapplication.features.page2.domain.usecases.DownloadProductImageDrawableUseCase
import com.example.testapplication.features.page2.domain.usecases.DownloadProductImageUseCase
import com.example.testapplication.features.page2.domain.usecases.GetProductDetailInfoUseCase
import com.example.testapplication.features.page2.domain.usecases.impl.DownloadProductImageDrawableUseCaseImpl
import com.example.testapplication.features.page2.domain.usecases.impl.DownloadProductImageUseCaseImpl
import com.example.testapplication.features.page2.domain.usecases.impl.GetProductDetailInfoUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
internal interface Page2UseCaseModule {

    @Binds
    fun bindDownloadProductImageDrawableUseCase(impl: DownloadProductImageDrawableUseCaseImpl): DownloadProductImageDrawableUseCase

    @Binds
    fun bindDownloadProductImageUseCase(impl: DownloadProductImageUseCaseImpl): DownloadProductImageUseCase

    @Binds
    fun bindGetProductDetailInfoUseCase(impl: GetProductDetailInfoUseCaseImpl): GetProductDetailInfoUseCase

}
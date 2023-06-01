package com.example.testapplication.features.page2.domain.usecases.impl

import com.example.testapplication.features.page2.domain.Page2Repository
import com.example.testapplication.features.page2.domain.entities.ProductDetailInfo
import com.example.testapplication.features.page2.domain.usecases.GetProductDetailInfoUseCase
import javax.inject.Inject

internal class GetProductDetailInfoUseCaseImpl @Inject constructor(private val repository: Page2Repository) :
    GetProductDetailInfoUseCase {

    override fun getProductDetailInfo(callback: (ProductDetailInfo) -> Unit) =
        repository.getProductDetailInfo(callback)

}
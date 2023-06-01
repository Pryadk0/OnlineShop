package com.example.testapplication.features.page2.domain.usecases

import com.example.testapplication.features.page2.domain.entities.ProductDetailInfo

internal interface GetProductDetailInfoUseCase {

    fun getProductDetailInfo(callback: (ProductDetailInfo) -> Unit)

}
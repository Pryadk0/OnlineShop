package com.example.testapplication.features.page1.domain.usecases

import com.example.testapplication.features.page1.domain.entities.FlashSaleProduct
import com.example.testapplication.features.page1.domain.entities.LatestProduct

internal interface GetAllProductsUseCase {

    fun getAllProducts(callback: (List<LatestProduct>, List<FlashSaleProduct>) -> Unit)

}
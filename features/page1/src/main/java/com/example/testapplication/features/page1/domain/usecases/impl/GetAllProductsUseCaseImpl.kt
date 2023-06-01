package com.example.testapplication.features.page1.domain.usecases.impl

import com.example.testapplication.features.page1.domain.entities.FlashSaleProduct
import com.example.testapplication.features.page1.domain.entities.LatestProduct
import com.example.testapplication.features.page1.domain.Page1Repository
import com.example.testapplication.features.page1.domain.usecases.GetAllProductsUseCase
import javax.inject.Inject

internal class GetAllProductsUseCaseImpl @Inject constructor(private val repository: Page1Repository) :
    GetAllProductsUseCase {

    override fun getAllProducts(callback: (List<LatestProduct>, List<FlashSaleProduct>) -> Unit) =
        repository.getAllProducts(callback)

}
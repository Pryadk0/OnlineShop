package com.example.testapplication.features.page1.domain.usecases

import com.example.testapplication.features.page1.domain.entities.FlashSaleProduct
import com.example.testapplication.features.page1.domain.entities.LatestProduct
import com.example.testapplication.features.page1.domain.Page1Repository
import javax.inject.Inject

internal class GetAllProductsUseCase @Inject constructor(private val repository: Page1Repository) {

    fun getAllProducts(callback: (List<LatestProduct>, List<FlashSaleProduct>) -> Unit) {
        repository.getAllProducts(callback)
    }
}
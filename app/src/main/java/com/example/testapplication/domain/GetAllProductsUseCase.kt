package com.example.testapplication.domain

import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(private val repository: Repository) {

    fun getAllProducts(callback: (List<LatestProduct>, List<FlashSaleProduct>) -> Unit) {
        repository.getAllProducts(callback)
    }
}
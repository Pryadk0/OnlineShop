package com.example.testapplication.features.page2.domain.usecases

import com.example.testapplication.features.page2.domain.entities.ProductDetailInfo
import com.example.testapplication.features.page2.domain.Page2Repository
import javax.inject.Inject

class GetProductDetailInfoUseCase @Inject constructor(private val repository: Page2Repository) {

    fun getProductDetailInfo(callback: (ProductDetailInfo) -> Unit){
        repository.getProductDetailInfo(callback)
    }
}
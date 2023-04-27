package com.example.page2.domain.usecases

import com.example.page2.domain.entities.ProductDetailInfo
import com.example.page2.domain.repositories.Page2Repository
import javax.inject.Inject

class GetProductDetailInfoUseCase @Inject constructor(private val repository: Page2Repository) {

    fun getProductDetailInfo(callback: (ProductDetailInfo) -> Unit){
        repository.getProductDetailInfo(callback)
    }
}
package com.example.testapplication.domain

import javax.inject.Inject

class GetProductDetailInfoUseCase @Inject constructor(private val repository: Repository) {

    fun getProductDetailInfo(callback: (ProductDetailInfo) -> Unit){
        repository.getProductDetailInfo(callback)
    }
}
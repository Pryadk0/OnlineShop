package com.example.testapplication.data.page2.datasources.remote

import com.example.testapplication.data.network.entities.ProductDetailResponseDto
import com.example.testapplication.data.page2.entities.ProductDetailInfoDataEntity
import javax.inject.Inject

class Page2RemoteDataSourceMapper @Inject constructor() {

    fun mapProductDetailResponseDtoToProductDetailInfoDataEntity(productDetailResponseDto: ProductDetailResponseDto): ProductDetailInfoDataEntity =
        ProductDetailInfoDataEntity(
            productDetailResponseDto.name,
            productDetailResponseDto.description,
            productDetailResponseDto.rating,
            productDetailResponseDto.numberOfReviews,
            productDetailResponseDto.price,
            productDetailResponseDto.colors,
            productDetailResponseDto.imageUrls
        )
}
package com.example.page2.datasources.remote

import com.example.network.entities.ProductDetailResponseDto
import com.example.page2.entities.ProductDetailInfoDataEntity
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
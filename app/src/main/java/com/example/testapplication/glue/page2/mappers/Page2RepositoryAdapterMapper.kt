package com.example.testapplication.glue.page2.mappers

import com.example.page2.domain.entities.ProductDetailInfo
import com.example.page2.entities.ProductDetailInfoDataEntity
import javax.inject.Inject

class Page2RepositoryAdapterMapper @Inject constructor() {

    fun mapProductDetailInfoDataEntityToProductDetailInfo(productDetailInfoDataEntity: ProductDetailInfoDataEntity): ProductDetailInfo =
        ProductDetailInfo(
            productDetailInfoDataEntity.name,
            productDetailInfoDataEntity.description,
            productDetailInfoDataEntity.rating,
            productDetailInfoDataEntity.numberOfReviews,
            productDetailInfoDataEntity.price,
            productDetailInfoDataEntity.colors,
            productDetailInfoDataEntity.imageUrls
        )
}
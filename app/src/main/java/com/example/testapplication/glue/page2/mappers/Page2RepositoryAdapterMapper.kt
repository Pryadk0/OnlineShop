package com.example.testapplication.glue.page2.mappers

import com.example.testapplication.data.page2.entities.ProductDetailInfoDataEntity
import com.example.testapplication.features.page2.domain.entities.ProductDetailInfo
import javax.inject.Inject

internal class Page2RepositoryAdapterMapper @Inject constructor() {

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
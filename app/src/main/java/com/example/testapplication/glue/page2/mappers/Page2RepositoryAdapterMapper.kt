package com.example.testapplication.glue.page2.mappers

import com.example.page2.domain.entities.ProductDetailInfo
import com.example.page2.entities.ProductDetailInfoDataEntity

class Page2RepositoryAdapterMapper {

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
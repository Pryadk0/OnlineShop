package com.example.testapplication.glue.page1.mappers

import com.example.page1.domain.entities.FlashSaleProduct
import com.example.page1.domain.entities.LatestProduct
import com.example.page1.entities.FlashSaleProductDataEntity
import com.example.page1.entities.LatestProductDataEntity

class Page1RepositoryAdapterMapper {

    private fun mapLatestProductDataEntityToLatestProduct(latestProductDataEntity: LatestProductDataEntity): LatestProduct =
        LatestProduct(
            latestProductDataEntity.category,
            latestProductDataEntity.name,
            latestProductDataEntity.price,
            latestProductDataEntity.imageUrl
        )

    private fun mapFlashSaleProductDataEntityToFlashSaleProduct(flashSaleProductDataEntity: FlashSaleProductDataEntity): FlashSaleProduct =
        FlashSaleProduct(
            flashSaleProductDataEntity.category,
            flashSaleProductDataEntity.name,
            flashSaleProductDataEntity.price,
            flashSaleProductDataEntity.discount,
            flashSaleProductDataEntity.imageUrl
        )


    fun mapLatestProductDataEntityListToLatestProductList(latestProductDataEntityList: List<LatestProductDataEntity>): List<LatestProduct> =
        latestProductDataEntityList.map { mapLatestProductDataEntityToLatestProduct(it) }

    fun mapFlashSaleProductDataEntityListToFlashSaleProductList(flashSaleProductDataEntityList: List<FlashSaleProductDataEntity>): List<FlashSaleProduct> =
        flashSaleProductDataEntityList.map { mapFlashSaleProductDataEntityToFlashSaleProduct(it) }

}
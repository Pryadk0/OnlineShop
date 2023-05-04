package com.example.page1.datasources.remote

import com.example.network.entities.FlashSaleProductDto
import com.example.network.entities.LatestProductDto
import com.example.page1.entities.FlashSaleProductDataEntity
import com.example.page1.entities.LatestProductDataEntity
import javax.inject.Inject

class Page1RemoteDataSourceMapper @Inject constructor() {

    private fun mapLatestProductDtoToLatestProductDataEntity(latestProductDto: LatestProductDto) =
        LatestProductDataEntity(
            latestProductDto.category,
            latestProductDto.name,
            latestProductDto.price,
            latestProductDto.imageUrl
        )

    fun mapLatestProductDtoListToLatestProductDataEntityList(latestProductDtoList: List<LatestProductDto>) =
        latestProductDtoList.map { mapLatestProductDtoToLatestProductDataEntity(it) }

    private fun mapFlashSaleProductDtoToFlashSaleProductDataEntity(flashSaleProductDto: FlashSaleProductDto) =
        FlashSaleProductDataEntity(
            flashSaleProductDto.category,
            flashSaleProductDto.name,
            flashSaleProductDto.price,
            flashSaleProductDto.discount,
            flashSaleProductDto.imageUrl
        )

    fun mapFlashSaleProductDtoListToFlashSaleProductDataEntityList(flashSaleProductDtoList: List<FlashSaleProductDto>) =
        flashSaleProductDtoList.map { mapFlashSaleProductDtoToFlashSaleProductDataEntity(it) }
}
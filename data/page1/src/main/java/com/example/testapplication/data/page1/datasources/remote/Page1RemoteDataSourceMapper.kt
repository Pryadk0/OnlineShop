package com.example.testapplication.data.page1.datasources.remote

import com.example.testapplication.data.network.entities.FlashSaleProductDto
import com.example.testapplication.data.network.entities.LatestProductDto
import com.example.testapplication.data.page1.entities.FlashSaleProductDataEntity
import com.example.testapplication.data.page1.entities.LatestProductDataEntity
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
package com.example.testapplication.data.mapper

import com.example.data.old.datasource.local.model.UserDbModel
import com.example.network.entities.FlashSaleProductDto
import com.example.network.entities.LatestProductDto
import com.example.network.entities.ProductDetailResponseDto
import com.example.testapplication.domain.FlashSaleProduct
import com.example.testapplication.domain.LatestProduct
import com.example.testapplication.domain.ProductDetailInfo
import com.example.testapplication.domain.User
import javax.inject.Inject

class Mapper @Inject constructor() {

    private fun mapLatestProductDtoToLatestProduct(latestProductDto: com.example.network.entities.LatestProductDto) =
        LatestProduct(
            latestProductDto.category,
            latestProductDto.name,
            latestProductDto.price,
            latestProductDto.imageUrl
        )

    fun mapLatestProductDtoListToLatestProductList(latestProductDtoList: List<com.example.network.entities.LatestProductDto>) =
        latestProductDtoList.map { mapLatestProductDtoToLatestProduct(it) }

    private fun mapFlashSaleProductDtoToFlashSaleProduct(flashSaleProductDto: com.example.network.entities.FlashSaleProductDto) =
        FlashSaleProduct(
            flashSaleProductDto.category,
            flashSaleProductDto.name,
            flashSaleProductDto.price,
            flashSaleProductDto.discount,
            flashSaleProductDto.imageUrl
        )

    fun mapFlashSaleProductDtoListToFlashSaleProductList(flashSaleProductDtoList: List<com.example.network.entities.FlashSaleProductDto>) =
        flashSaleProductDtoList.map { mapFlashSaleProductDtoToFlashSaleProduct(it) }

    fun mapUserToUserDbModel(user: User) =
        UserDbModel(user.firstName, user.lastName, user.email)

    fun mapUserDbModelToUser(userDbModel: UserDbModel) = User(
        userDbModel.firstName, userDbModel.lastName, userDbModel.email
    )

    fun mapProductDetailResponseDtoToProductDetailInfo(productDetailResponseDto: com.example.network.entities.ProductDetailResponseDto) =
        ProductDetailInfo(
            productDetailResponseDto.name,
            productDetailResponseDto.description,
            productDetailResponseDto.rating,
            productDetailResponseDto.numberOfReviews,
            productDetailResponseDto.price,
            productDetailResponseDto.colors,
            productDetailResponseDto.imageUrls
        )
}
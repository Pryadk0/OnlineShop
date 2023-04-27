package com.example.testapplication.data.mapper

import com.example.data.old.datasource.local.model.UserDbModel
import com.example.data.old.datasource.remote.model.FlashSaleProductDto
import com.example.data.old.datasource.remote.model.LatestProductDto
import com.example.data.old.datasource.remote.model.ProductDetailResponseDto
import com.example.testapplication.domain.FlashSaleProduct
import com.example.testapplication.domain.LatestProduct
import com.example.testapplication.domain.ProductDetailInfo
import com.example.testapplication.domain.User
import javax.inject.Inject

class Mapper @Inject constructor() {

    private fun mapLatestProductDtoToLatestProduct(latestProductDto: LatestProductDto) =
        LatestProduct(
            latestProductDto.category,
            latestProductDto.name,
            latestProductDto.price,
            latestProductDto.imageUrl
        )

    fun mapLatestProductDtoListToLatestProductList(latestProductDtoList: List<LatestProductDto>) =
        latestProductDtoList.map { mapLatestProductDtoToLatestProduct(it) }

    private fun mapFlashSaleProductDtoToFlashSaleProduct(flashSaleProductDto: FlashSaleProductDto) =
        FlashSaleProduct(
            flashSaleProductDto.category,
            flashSaleProductDto.name,
            flashSaleProductDto.price,
            flashSaleProductDto.discount,
            flashSaleProductDto.imageUrl
        )

    fun mapFlashSaleProductDtoListToFlashSaleProductList(flashSaleProductDtoList: List<FlashSaleProductDto>) =
        flashSaleProductDtoList.map { mapFlashSaleProductDtoToFlashSaleProduct(it) }

    fun mapUserToUserDbModel(user: User) =
        UserDbModel(user.firstName, user.lastName, user.email)

    fun mapUserDbModelToUser(userDbModel: UserDbModel) = User(
        userDbModel.firstName, userDbModel.lastName, userDbModel.email
    )

    fun mapProductDetailResponseDtoToProductDetailInfo(productDetailResponseDto: ProductDetailResponseDto) =
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
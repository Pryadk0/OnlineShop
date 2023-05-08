package com.example.testapplication.data.network.entities

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class FlashSaleProductsResponse(
    @SerializedName("flash_sale")
    @Expose
    val flashSaleList: List<FlashSaleProductDto>
)
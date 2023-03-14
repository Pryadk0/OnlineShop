package com.example.testapplication.data.datasource.remote.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class FlashSaleProductsResponse(
    @SerializedName("flash_sale")
    @Expose
    val flashSaleList: List<FlashSaleProductDto>
)
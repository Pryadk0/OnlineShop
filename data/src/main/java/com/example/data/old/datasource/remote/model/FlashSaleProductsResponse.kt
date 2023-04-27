package com.example.data.old.datasource.remote.model

import com.example.data.old.datasource.remote.model.FlashSaleProductDto
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class FlashSaleProductsResponse(
    @SerializedName("flash_sale")
    @Expose
    val flashSaleList: List<FlashSaleProductDto>
)
package com.example.network.entities

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class FlashSaleProductDto(
    @SerializedName("category")
    @Expose
    val category: String,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("price")
    @Expose
    val price: Double,

    @SerializedName("discount")
    @Expose
    val discount: Int,

    @SerializedName("image_url")
    @Expose
    val imageUrl: String,
)
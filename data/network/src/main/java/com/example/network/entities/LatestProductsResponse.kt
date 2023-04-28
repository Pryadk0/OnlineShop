package com.example.network.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class LatestProductsResponse (
    @SerializedName("latest")
    @Expose
    val latestProductList: List<LatestProductDto>
)

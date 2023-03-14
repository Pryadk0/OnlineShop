package com.example.testapplication.data.datasource.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class LatestProductsResponse (
    @SerializedName("latest")
    @Expose
    val latestProductList: List<LatestProductDto>
)

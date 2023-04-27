package com.example.data.old.datasource.remote.model

import com.example.data.old.datasource.remote.model.LatestProductDto
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class LatestProductsResponse (
    @SerializedName("latest")
    @Expose
    val latestProductList: List<LatestProductDto>
)

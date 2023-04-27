package com.example.data.old.datasource.remote.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class LatestProductDto(
    @SerializedName("category")
    @Expose
    val category: String,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("price")
    @Expose
    val price: Double,

    @SerializedName("image_url")
    @Expose
    val imageUrl: String
)
package com.example.testapplication.data.network.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductDetailResponseDto(
    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("description")
    @Expose
    val description: String,

    @SerializedName("rating")
    @Expose
    val rating: Double,

    @SerializedName("number_of_reviews")
    @Expose
    val numberOfReviews: Int,

    @SerializedName("price")
    @Expose
    val price: Double,

    @SerializedName("colors")
    @Expose
    val colors: List<String>,

    @SerializedName("image_urls")
    @Expose
    val imageUrls: List<String>
)
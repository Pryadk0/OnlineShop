package com.example.data.old.datasource.remote.model

data class ProductDetailInfoDataEntity(
    val name: String,
    val description: String,
    val rating: Double,
    val numberOfReviews: Int,
    val price: Double,
    val colors: List<String>,
    val imageUrls: List<String>
)
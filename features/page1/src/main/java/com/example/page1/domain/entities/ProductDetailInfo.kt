package com.example.page1.domain.entities

data class ProductDetailInfo(
    val name: String,
    val description: String,
    val rating: Double,
    val numberOfReviews: Int,
    val price: Double,
    val colors: List<String>,
    val imageUrls: List<String>
)
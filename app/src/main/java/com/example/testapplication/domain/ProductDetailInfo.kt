package com.example.testapplication.domain

data class ProductDetailInfo(
    val name: String,
    val description: String,
    val rating: Double,
    val numberOfReviews: Int,
    val price: Double,
    val colors: List<String>,
    val imageUrls: List<String>

)
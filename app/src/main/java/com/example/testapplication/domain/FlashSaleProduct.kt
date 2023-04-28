package com.example.testapplication.domain

data class FlashSaleProduct(
    val category: String,
    val name: String,
    val price: Double,
    val discount: Int,
    val imageUrl: String
)
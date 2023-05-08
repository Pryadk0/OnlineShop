package com.example.testapplication.features.page2.domain

import android.widget.ImageView

interface ProductImageRepository {

    fun downloadProductImage(imageUrl: String, container: ImageView)

}
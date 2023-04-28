package com.example.page2.presentation.adapters.repositories

import android.widget.ImageView

interface ProductImageRepository {

    fun downloadProductImage(imageUrl: String, container: ImageView)

}
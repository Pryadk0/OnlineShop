package com.example.page2

import android.widget.ImageView

interface ProductImageDataRepository {

    fun downloadProductImage(imageUrl: String, container: ImageView)

}
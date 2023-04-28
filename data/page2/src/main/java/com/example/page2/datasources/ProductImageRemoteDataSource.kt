package com.example.page2.datasources

import android.widget.ImageView

interface ProductImageRemoteDataSource {

    fun downloadProductImage(imageUrl: String, container: ImageView)

}
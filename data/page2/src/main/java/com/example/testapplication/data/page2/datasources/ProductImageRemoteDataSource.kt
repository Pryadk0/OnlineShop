package com.example.testapplication.data.page2.datasources

import android.widget.ImageView

interface ProductImageRemoteDataSource {

    fun downloadProductImage(imageUrl: String, container: ImageView)

}
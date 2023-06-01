package com.example.testapplication.features.page1.domain.usecases

import android.widget.ImageView

internal interface DownloadProductImageUseCase {

    fun downloadProductImage(imageUrl: String, container: ImageView)

}
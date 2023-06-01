package com.example.testapplication.features.page2.domain.usecases

import android.widget.ImageView

internal interface DownloadProductImageUseCase {

    fun downloadProductImage(imageUrl: String, container: ImageView)

}
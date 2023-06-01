package com.example.testapplication.features.page2.domain.usecases

import android.graphics.Bitmap

internal interface DownloadProductImageUseCase {

    fun downloadProductImage(imageUrl: String, callback: (Bitmap?) -> Unit)

}
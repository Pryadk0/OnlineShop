package com.example.testapplication.features.page2.domain.usecases

import android.graphics.Bitmap

internal interface DownloadProductImageDrawableUseCase {

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit)

}
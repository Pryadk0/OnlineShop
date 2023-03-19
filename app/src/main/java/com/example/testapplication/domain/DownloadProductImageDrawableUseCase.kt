package com.example.testapplication.domain

import android.graphics.Bitmap
import javax.inject.Inject

class DownloadProductImageDrawableUseCase @Inject constructor(private val repository: Repository) {

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) =
        repository.downloadProductImageDrawable(imageUrl, callback)
}
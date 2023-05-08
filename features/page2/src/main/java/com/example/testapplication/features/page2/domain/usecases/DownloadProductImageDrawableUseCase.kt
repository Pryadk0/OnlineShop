package com.example.testapplication.features.page2.domain.usecases

import android.graphics.Bitmap
import com.example.testapplication.features.page2.domain.Page2Repository
import javax.inject.Inject

class DownloadProductImageDrawableUseCase @Inject constructor(private val repository: Page2Repository) {

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) =
        repository.downloadProductImageDrawable(imageUrl, callback)
}
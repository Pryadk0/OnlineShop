package com.example.page2.domain.usecases

import android.graphics.Bitmap
import com.example.page2.presentation.adapters.repositories.Page2Repository
import javax.inject.Inject

class DownloadProductImageDrawableUseCase @Inject constructor(private val repository: Page2Repository) {

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) =
        repository.downloadProductImageDrawable(imageUrl, callback)
}
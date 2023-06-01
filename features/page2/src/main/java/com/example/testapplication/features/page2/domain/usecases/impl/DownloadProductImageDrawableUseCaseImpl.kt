package com.example.testapplication.features.page2.domain.usecases.impl

import android.graphics.Bitmap
import com.example.testapplication.features.page2.domain.usecases.DownloadProductImageDrawableUseCase
import com.example.testapplication.features.page2.domain.Page2Repository
import javax.inject.Inject

internal class DownloadProductImageDrawableUseCaseImpl @Inject constructor(private val repository: Page2Repository) :
    DownloadProductImageDrawableUseCase {

    override fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) =
        repository.downloadProductImageDrawable(imageUrl, callback)
}
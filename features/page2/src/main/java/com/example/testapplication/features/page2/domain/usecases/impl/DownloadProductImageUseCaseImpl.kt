package com.example.testapplication.features.page2.domain.usecases.impl

import android.graphics.Bitmap
import com.example.testapplication.features.page2.domain.Page2Repository
import com.example.testapplication.features.page2.domain.usecases.DownloadProductImageUseCase
import javax.inject.Inject

internal class DownloadProductImageUseCaseImpl @Inject constructor(private val repository: Page2Repository) :
    DownloadProductImageUseCase {

    override fun downloadProductImage(imageUrl: String, callback: (Bitmap?) -> Unit) =
        repository.downloadProductImage(imageUrl, callback)
}
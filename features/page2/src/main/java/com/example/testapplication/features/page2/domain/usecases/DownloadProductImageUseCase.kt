package com.example.testapplication.features.page2.domain.usecases

import android.widget.ImageView
import com.example.testapplication.features.page2.domain.ProductImageRepository
import javax.inject.Inject

internal class DownloadProductImageUseCase @Inject constructor(private val repository: ProductImageRepository) {

    fun downloadProductImage(imageUrl: String, container: ImageView) =
        repository.downloadProductImage(imageUrl, container)
}
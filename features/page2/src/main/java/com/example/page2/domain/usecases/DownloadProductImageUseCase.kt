package com.example.page2.domain.usecases

import android.widget.ImageView
import com.example.page2.presentation.adapters.repositories.ProductImageRepository
import javax.inject.Inject

class DownloadProductImageUseCase @Inject constructor(private val repository: ProductImageRepository) {

    fun downloadProductImage(imageUrl: String, container: ImageView) =
        repository.downloadProductImage(imageUrl, container)
}
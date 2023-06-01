package com.example.testapplication.features.page2.domain.usecases.impl

import android.widget.ImageView
import com.example.testapplication.features.page2.domain.usecases.DownloadProductImageUseCase
import com.example.testapplication.features.page2.domain.ProductImageRepository
import javax.inject.Inject

internal class DownloadProductImageUseCaseImpl @Inject constructor(private val repository: ProductImageRepository) :
    DownloadProductImageUseCase {

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        repository.downloadProductImage(imageUrl, container)
}
package com.example.testapplication.features.page1.domain.usecases

import android.widget.ImageView
import com.example.testapplication.features.page1.domain.Page1Repository
import javax.inject.Inject

internal class DownloadProductImageUseCase @Inject constructor(private val repository: Page1Repository) {

    fun downloadProductImage(imageUrl: String, container: ImageView) =
        repository.downloadProductImage(imageUrl, container)
}
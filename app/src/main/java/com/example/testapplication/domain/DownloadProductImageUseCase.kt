package com.example.testapplication.domain

import android.widget.ImageView
import javax.inject.Inject

class DownloadProductImageUseCase @Inject constructor(private val repository: Repository) {

    fun downloadProductImage(imageUrl: String, container: ImageView) =
        repository.downloadProductImage(imageUrl, container)
}
package com.example.page1.domain.usecases

import android.widget.ImageView
import com.example.page1.domain.repositories.Page1Repository
import javax.inject.Inject

class DownloadProductImageUseCase @Inject constructor(private val repository: Page1Repository) {

    fun downloadProductImage(imageUrl: String, container: ImageView) =
        repository.downloadProductImage(imageUrl, container)
}
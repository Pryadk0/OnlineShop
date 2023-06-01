package com.example.testapplication.features.page1.domain.usecases.impl

import android.widget.ImageView
import com.example.testapplication.features.page1.domain.Page1Repository
import com.example.testapplication.features.page1.domain.usecases.DownloadProductImageUseCase
import javax.inject.Inject

internal class DownloadProductImageUseCaseImpl @Inject constructor(private val repository: Page1Repository) :
    DownloadProductImageUseCase {

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        repository.downloadProductImage(imageUrl, container)

}
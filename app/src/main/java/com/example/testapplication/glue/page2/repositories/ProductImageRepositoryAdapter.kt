package com.example.testapplication.glue.page2.repositories

import android.widget.ImageView
import com.example.testapplication.data.page2.ProductImageDataRepository
import com.example.testapplication.features.page2.domain.ProductImageRepository
import javax.inject.Inject

internal class ProductImageRepositoryAdapter @Inject constructor(
    private val dataRepository: ProductImageDataRepository
) : ProductImageRepository {

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        dataRepository.downloadProductImage(imageUrl, container)

}
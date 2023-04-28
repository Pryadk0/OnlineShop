package com.example.testapplication.glue.page2.repositories

import android.widget.ImageView
import com.example.page2.ProductImageDataRepository
import com.example.page2.domain.ProductImageRepository
import javax.inject.Inject

class ProductImageRepositoryAdapter @Inject constructor(
    private val dataRepository: ProductImageDataRepository
) : ProductImageRepository {

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        dataRepository.downloadProductImage(imageUrl, container)

}
package com.example.testapplication.data.page2

import android.widget.ImageView
import com.example.testapplication.data.page2.datasources.ProductImageRemoteDataSource
import javax.inject.Inject

class ProductImageDataRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProductImageRemoteDataSource
): ProductImageDataRepository {

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        remoteDataSource.downloadProductImage(imageUrl, container)

}
package com.example.testapplication.data.page2

import android.graphics.Bitmap
import com.example.testapplication.data.page2.datasources.Page2RemoteDataSource
import com.example.testapplication.data.page2.entities.ProductDetailInfoDataEntity
import javax.inject.Inject


class Page2DataRepositoryImpl @Inject constructor(
    private val remoteDataSource: Page2RemoteDataSource
): Page2DataRepository {

    override fun getProductDetailInfo(callback: (ProductDetailInfoDataEntity) -> Unit) =
        remoteDataSource.getProductDetailInfo(callback)

    override fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) =
        remoteDataSource.downloadProductImageDrawable(imageUrl, callback)

}
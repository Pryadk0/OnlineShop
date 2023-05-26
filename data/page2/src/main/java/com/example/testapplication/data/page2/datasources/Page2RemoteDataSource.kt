package com.example.testapplication.data.page2.datasources

import android.graphics.Bitmap
import com.example.testapplication.data.page2.entities.ProductDetailInfoDataEntity

interface Page2RemoteDataSource {

    fun getProductDetailInfo(callback: (ProductDetailInfoDataEntity) -> Unit)

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit)

}
package com.example.testapplication.data.page2

import android.graphics.Bitmap
import com.example.testapplication.data.page2.entities.ProductDetailInfoDataEntity

interface Page2DataRepository {

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit)

    fun getProductDetailInfo(callback: (ProductDetailInfoDataEntity) -> Unit)
}
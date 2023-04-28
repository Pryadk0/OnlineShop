package com.example.page2.domain

import android.graphics.Bitmap
import com.example.page2.domain.entities.ProductDetailInfo

interface Page2Repository {

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit)

    fun getProductDetailInfo(callback: (ProductDetailInfo) -> Unit)

}
package com.example.page2.presentation.adapters.repositories

import android.graphics.Bitmap
import com.example.page2.domain.entities.ProductDetailInfo

interface Page2Repository {

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit)

    fun getProductDetailInfo(callback: (ProductDetailInfo) -> Unit)

}
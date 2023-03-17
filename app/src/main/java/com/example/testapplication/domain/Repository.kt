package com.example.testapplication.domain

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView

interface Repository {

    fun getAllProducts(callback: (List<LatestProduct>, List<FlashSaleProduct>) -> Unit)

    fun downloadProductImage(imageUrl: String, container: ImageView)

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit)

    fun getUserFormDb(firstName: String): User?

    fun writeUserInDb(user: User)

    fun getProductDetailInfo(callback: (ProductDetailInfo) -> Unit)
}
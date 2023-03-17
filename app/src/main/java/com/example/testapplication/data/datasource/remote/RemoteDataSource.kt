package com.example.testapplication.data.datasource.remote

import android.graphics.Bitmap
import android.widget.ImageView
import com.example.testapplication.domain.FlashSaleProduct
import com.example.testapplication.domain.LatestProduct
import com.example.testapplication.domain.ProductDetailInfo
import io.reactivex.Observable

interface RemoteDataSource {

    fun getLatestProductsResponse(): Observable<List<LatestProduct>>

    fun getFlashSaleProductsResponse(): Observable<List<FlashSaleProduct>>

    fun downloadProductImage(imageUrl: String, container: ImageView)

    fun getProductDetailInfo(): Observable<ProductDetailInfo>

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit)
}
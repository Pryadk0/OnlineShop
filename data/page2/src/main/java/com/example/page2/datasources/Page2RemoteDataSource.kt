package com.example.page2.datasources

import android.graphics.Bitmap
import com.example.page2.entities.ProductDetailInfoDataEntity
import io.reactivex.Observable

interface Page2RemoteDataSource {

    fun getProductDetailInfo(): Observable<ProductDetailInfoDataEntity>

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit)

}
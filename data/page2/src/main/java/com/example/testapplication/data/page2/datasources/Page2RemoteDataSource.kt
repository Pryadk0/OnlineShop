package com.example.testapplication.data.page2.datasources

import android.graphics.Bitmap
import com.example.testapplication.data.page2.entities.ProductDetailInfoDataEntity
import io.reactivex.Observable

interface Page2RemoteDataSource {

    fun getProductDetailInfo(): Observable<ProductDetailInfoDataEntity>

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit)

}
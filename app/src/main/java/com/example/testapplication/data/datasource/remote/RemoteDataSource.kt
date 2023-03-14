package com.example.testapplication.data.datasource.remote

import android.widget.ImageView
import com.example.testapplication.domain.FlashSaleProduct
import com.example.testapplication.domain.LatestProduct
import io.reactivex.Observable

interface RemoteDataSource {

    fun getLatestProductsResponse(): Observable<List<LatestProduct>>

    fun getFlashSaleProductsResponse(): Observable<List<FlashSaleProduct>>

    fun downloadProductImage(imageUrl: String, container: ImageView)
}
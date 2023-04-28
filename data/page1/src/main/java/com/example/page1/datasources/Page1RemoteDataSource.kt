package com.example.page1.datasources

import android.widget.ImageView
import com.example.page1.entities.FlashSaleProductDataEntity
import com.example.page1.entities.LatestProductDataEntity
import io.reactivex.Observable

interface Page1RemoteDataSource {

    fun getLatestProductsResponse(): Observable<List<LatestProductDataEntity>>

    fun getFlashSaleProductsResponse(): Observable<List<FlashSaleProductDataEntity>>

    fun downloadProductImage(imageUrl: String, container: ImageView)

    fun getSearchWords(): Observable<List<String>>
}
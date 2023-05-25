package com.example.testapplication.data.page1.datasources

import android.widget.ImageView
import com.example.testapplication.data.page1.entities.FlashSaleProductDataEntity
import com.example.testapplication.data.page1.entities.LatestProductDataEntity

interface Page1RemoteDataSource {

    fun getAllProducts(callback: (List<LatestProductDataEntity>, List<FlashSaleProductDataEntity>) -> Unit)

    fun downloadProductImage(imageUrl: String, container: ImageView)

    fun getSearchWords(callback: (List<String>) -> Unit)
}
package com.example.testapplication.data.page1

import android.widget.ImageView
import com.example.testapplication.data.page1.entities.FlashSaleProductDataEntity
import com.example.testapplication.data.page1.entities.LatestProductDataEntity

interface Page1DataRepository {

    fun getAllProducts(callback: (List<LatestProductDataEntity>, List<FlashSaleProductDataEntity>) -> Unit)

    fun downloadProductImage(imageUrl: String, container: ImageView)

    fun getSearchWords(callback: (List<String>) -> Unit)
}
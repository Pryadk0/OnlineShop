package com.example.page1.domain.repositories

import android.widget.ImageView
import com.example.page1.domain.entities.FlashSaleProduct
import com.example.page1.domain.entities.LatestProduct

interface Page1Repository {

    fun getAllProducts(callback: (List<LatestProduct>, List<FlashSaleProduct>) -> Unit)

    fun downloadProductImage(imageUrl: String, container: ImageView)

    fun getSearchWords(callback: (List<String>) -> Unit)
}


package com.example.testapplication.domain

import android.widget.ImageView

interface Repository {

    fun getAllProducts(callback: (List<LatestProduct>, List<FlashSaleProduct>) -> Unit)

    fun downloadProductImage(imageUrl: String, container: ImageView)

    fun getUserFormDb(firstName: String): User?

    fun writeUserInDb(user: User)
}
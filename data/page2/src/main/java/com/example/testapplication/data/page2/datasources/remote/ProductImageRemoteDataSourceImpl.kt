package com.example.testapplication.data.page2.datasources.remote

import android.widget.ImageView
import com.example.testapplication.data.page2.datasources.ProductImageRemoteDataSource
import com.squareup.picasso.Picasso
import javax.inject.Inject

class ProductImageRemoteDataSourceImpl @Inject constructor(): ProductImageRemoteDataSource {

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        Picasso.get()
            .load(imageUrl)
            .into(container)

}
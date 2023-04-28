package com.example.page2.datasources.remote

import android.widget.ImageView
import com.example.page2.datasources.ProductImageRemoteDataSource
import com.squareup.picasso.Picasso

class ProductImageRemoteDataSourceImpl: ProductImageRemoteDataSource {

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        Picasso.get()
            .load(imageUrl)
            .into(container)

}
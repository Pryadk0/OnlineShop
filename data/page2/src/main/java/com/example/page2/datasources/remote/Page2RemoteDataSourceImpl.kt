package com.example.page2.datasources.remote

import android.graphics.Bitmap
import com.example.network.ApiService
import com.example.page2.datasources.Page2RemoteDataSource
import com.example.page2.entities.ProductDetailInfoDataEntity
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import javax.inject.Inject

class Page2RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Page2RemoteDataSourceMapper
) : Page2RemoteDataSource {

    override fun getProductDetailInfo(): Observable<ProductDetailInfoDataEntity> =
        apiService.getProductDetailInfo().map {
            mapper.mapProductDetailResponseDtoToProductDetailInfoDataEntity(it)
        }

    override fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) =
        Thread { callback(Picasso.get().load(imageUrl).get()) }.start()


}
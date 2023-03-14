package com.example.testapplication.data.datasource.remote


import android.widget.ImageView
import com.example.testapplication.data.mapper.Mapper
import com.example.testapplication.data.network.ApiService
import com.example.testapplication.domain.FlashSaleProduct
import com.example.testapplication.domain.LatestProduct
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Mapper
    ) :
    RemoteDataSource {

    override fun getLatestProductsResponse(): Observable<List<LatestProduct>> {
        return apiService.getLatestProducts().map {
            mapper.mapLatestProductDtoListToLatestProductList(it.latestProductList)
        }
    }

    override fun getFlashSaleProductsResponse(): Observable<List<FlashSaleProduct>> {
        return apiService.getFlashSaleProducts().map {
            mapper.mapFlashSaleProductDtoListToFlashSaleProductList(it.flashSaleList)
        }
    }

    override fun downloadProductImage(imageUrl: String, container: ImageView) {
        Picasso.get()
            .load(imageUrl)
            .into(container)
    }
}
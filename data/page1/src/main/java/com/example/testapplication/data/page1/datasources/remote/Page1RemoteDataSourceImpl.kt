package com.example.testapplication.data.page1.datasources.remote


import android.widget.ImageView
import com.example.testapplication.data.network.ApiService
import com.example.testapplication.data.page1.datasources.Page1RemoteDataSource
import com.example.testapplication.data.page1.entities.FlashSaleProductDataEntity
import com.example.testapplication.data.page1.entities.LatestProductDataEntity
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import javax.inject.Inject

class Page1RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Page1RemoteDataSourceMapper
) : Page1RemoteDataSource {

    override fun getLatestProductsResponse(): Observable<List<LatestProductDataEntity>> =
        apiService.getLatestProducts().map {
            mapper.mapLatestProductDtoListToLatestProductDataEntityList(it.latestProductList)
        }

    override fun getFlashSaleProductsResponse(): Observable<List<FlashSaleProductDataEntity>> =
        apiService.getFlashSaleProducts().map {
            mapper.mapFlashSaleProductDtoListToFlashSaleProductDataEntityList(it.flashSaleList)
        }

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        Picasso.get()
            .load(imageUrl)
            .into(container)

    override fun getSearchWords(): Observable<List<String>> =
        apiService.getSearchWordsResponseDto().map { it.words }
}
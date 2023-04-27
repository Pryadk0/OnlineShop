package com.example.data.old.datasource.remote


import android.graphics.Bitmap
import android.widget.ImageView
import com.example.testapplication.data.mapper.Mapper
import com.example.network.ApiService
import com.example.testapplication.domain.FlashSaleProduct
import com.example.testapplication.domain.LatestProduct
import com.example.testapplication.domain.ProductDetailInfo
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: com.example.network.ApiService,
    private val mapper: Mapper
) :
    RemoteDataSource {

    override fun getLatestProductsResponse(): Observable<List<LatestProduct>> =
        apiService.getLatestProducts().map {
            mapper.mapLatestProductDtoListToLatestProductList(it.latestProductList)
        }


    override fun getFlashSaleProductsResponse(): Observable<List<FlashSaleProduct>> =
        apiService.getFlashSaleProducts().map {
            mapper.mapFlashSaleProductDtoListToFlashSaleProductList(it.flashSaleList)
        }

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        Picasso.get()
            .load(imageUrl)
            .into(container)

    override fun getProductDetailInfo(): Observable<ProductDetailInfo> =
        apiService.getProductDetailInfo().map {
            mapper.mapProductDetailResponseDtoToProductDetailInfo(it)
        }

    override fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) {
        Thread { callback(Picasso.get().load(imageUrl).get()) }.start()
    }

    override fun getSearchWords(): Observable<List<String>> =
        apiService.getSearchWordsResponseDto().map { it.words }
}
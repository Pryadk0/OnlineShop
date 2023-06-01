package com.example.testapplication.data.network


import com.example.testapplication.data.network.entities.FlashSaleProductsResponse
import com.example.testapplication.data.network.entities.LatestProductsResponse
import com.example.testapplication.data.network.entities.ProductDetailResponseDto
import com.example.testapplication.data.network.entities.SearchWordsResponseDto
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET(ENDPOINT_LATEST_PRODUCTS)
    fun getLatestProducts(): Single<LatestProductsResponse>

    @GET(ENDPOINT_FLASH_SALE)
    fun getFlashSaleProducts(): Single<FlashSaleProductsResponse>

    @GET(ENDPOINT_PRODUCT_DETAIL)
    fun getProductDetailInfo(): Single<ProductDetailResponseDto>

    @GET(ENDPOINT_SEARCH_WORDS)
    fun getSearchWordsResponseDto(): Single<SearchWordsResponseDto>


    companion object{
        private const val ENDPOINT_LATEST_PRODUCTS = "cc0071a1-f06e-48fa-9e90-b1c2a61eaca7"
        private const val ENDPOINT_FLASH_SALE = "a9ceeb6e-416d-4352-bde6-2203416576ac"
        private const val ENDPOINT_PRODUCT_DETAIL = "f7f99d04-4971-45d5-92e0-70333383c239"
        private const val ENDPOINT_SEARCH_WORDS = "4c9cd822-9479-4509-803d-63197e5a9e19"
    }

}
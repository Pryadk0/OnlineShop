package com.example.testapplication.data.network

import com.example.testapplication.data.datasource.remote.model.FlashSaleProductsResponse
import com.example.testapplication.data.datasource.remote.model.LatestProductsResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET(ENDPOINT_LATEST_PRODUCTS)
    fun getLatestProducts(): Observable<LatestProductsResponse>

    @GET(ENDPOINT_FLASH_SALE)
    fun getFlashSaleProducts(): Observable<FlashSaleProductsResponse>

    companion object{
        private const val ENDPOINT_LATEST_PRODUCTS = "cc0071a1-f06e-48fa-9e90-b1c2a61eaca7"
        private const val ENDPOINT_FLASH_SALE = "a9ceeb6e-416d-4352-bde6-2203416576ac"
    }

}
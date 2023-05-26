package com.example.testapplication.data.page1.datasources.remote


import android.util.Log
import android.widget.ImageView
import com.example.testapplication.data.network.ApiService
import com.example.testapplication.data.page1.datasources.Page1RemoteDataSource
import com.example.testapplication.data.page1.entities.FlashSaleProductDataEntity
import com.example.testapplication.data.page1.entities.LatestProductDataEntity
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

private const val TAG = "API_REQUEST"

class Page1RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Page1RemoteDataSourceMapper
) : Page1RemoteDataSource {

    private val compositeDisposable = CompositeDisposable()

    override fun getAllProducts(callback: (List<LatestProductDataEntity>, List<FlashSaleProductDataEntity>) -> Unit) {
        var latestProducts: List<LatestProductDataEntity> = mutableListOf()
        var flashSaleProduct: List<FlashSaleProductDataEntity> = mutableListOf()

        compositeDisposable.add(apiService.getLatestProducts()
            .map {
                mapper.mapLatestProductDtoListToLatestProductDataEntityList(it.latestProductList)
            }
            .map {
                latestProducts = it
                Log.i(TAG, "getLatestProductsResponse returned list sized ${it.size}")
            }
            .flatMap { apiService.getFlashSaleProducts() }
            .map {
                mapper.mapFlashSaleProductDtoListToFlashSaleProductDataEntityList(it.flashSaleList)
            }
            .map {
                flashSaleProduct = it
                Log.i(TAG, "getFlashSaleProductsResponse returned list sized ${it.size}")
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback(latestProducts, flashSaleProduct)
            }, {
                Log.i(TAG, "API getAllProducts request error: ${it.message}")
            })
        )
    }

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        Picasso.get()
            .load(imageUrl)
            .into(container)

    override fun getSearchWords(callback: (List<String>) -> Unit) {
        compositeDisposable.add(apiService.getSearchWordsResponseDto()
            .map { it.words }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback(it)
            }, {
                Log.i(TAG, "API getSearchWords request error: ${it.message}")
            })
        )
    }

    protected fun finalize() {
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }
}
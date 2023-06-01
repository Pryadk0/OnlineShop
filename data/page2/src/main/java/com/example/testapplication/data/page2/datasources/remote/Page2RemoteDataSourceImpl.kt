package com.example.testapplication.data.page2.datasources.remote

import android.graphics.Bitmap
import android.util.Log
import com.example.testapplication.data.network.ApiService
import com.example.testapplication.data.page2.datasources.Page2RemoteDataSource
import com.example.testapplication.data.page2.entities.ProductDetailInfoDataEntity
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

private const val TAG = "API_REQUEST"

class Page2RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Page2RemoteDataSourceMapper
) : Page2RemoteDataSource {

    private val compositeDisposable = CompositeDisposable()

    override fun getProductDetailInfo(callback: (ProductDetailInfoDataEntity) -> Unit) {
        compositeDisposable.add(apiService.getProductDetailInfo()
            .map { mapper.mapProductDetailResponseDtoToProductDetailInfoDataEntity(it) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback(it)
            }, {
                Log.i(TAG, "API getProductDetailInfo request error: ${it.message}")
            })
        )
    }

    override fun downloadProductImage(imageUrl: String, callback: (Bitmap?) -> Unit) =
        Thread { callback(Picasso.get().load(imageUrl).get()) }.start()

    protected fun finalize() {
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }
}
package com.example.page2

import android.graphics.Bitmap
import android.util.Log
import com.example.page2.datasources.Page2RemoteDataSource
import com.example.page2.entities.ProductDetailInfoDataEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

private const val TAG = "API_REQUEST"

class Page2DataRepositoryImpl @Inject constructor(
    private val remoteDataSource: Page2RemoteDataSource
): Page2DataRepository {

    private val compositeDisposable = CompositeDisposable()

    override fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) {
        remoteDataSource.downloadProductImageDrawable(imageUrl, callback)
    }

    override fun getProductDetailInfo(callback: (ProductDetailInfoDataEntity) -> Unit) {
        val disposable = remoteDataSource.getProductDetailInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback(it)
            }, {
                Log.i(TAG, "API getProductDetailInfo request error: ${it.message}")
            })
        disposable?.let { compositeDisposable.add(it) }
    }


    protected fun finalize() {
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }
}
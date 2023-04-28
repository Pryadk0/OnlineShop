package com.example.page1

import android.util.Log
import android.widget.ImageView
import com.example.page1.datasources.Page1RemoteDataSource
import com.example.page1.entities.FlashSaleProductDataEntity
import com.example.page1.entities.LatestProductDataEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

private const val TAG = "API_REQUEST"

class Page1DataRepositoryImpl(
    private val remoteDataSource: Page1RemoteDataSource,
    private val compositeDisposable: CompositeDisposable,
): Page1DataRepository {

    override fun getAllProducts(callback: (List<LatestProductDataEntity>, List<FlashSaleProductDataEntity>) -> Unit) {
        var latestProducts: List<LatestProductDataEntity> = mutableListOf()
        var flashSaleProduct: List<FlashSaleProductDataEntity> = mutableListOf()

        val disposable = remoteDataSource.getLatestProductsResponse()
            .map {
                latestProducts = it
                Log.i(TAG, "getLatestProductsResponse returned list sized ${it.size}")
            }
            .flatMap { remoteDataSource.getFlashSaleProductsResponse() }
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
        disposable?.let { compositeDisposable.add(it) }
    }

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        remoteDataSource.downloadProductImage(imageUrl, container)

    override fun getSearchWords(callback: (List<String>) -> Unit) {
        val disposable = remoteDataSource.getSearchWords()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback(it)
            }, {
                Log.i(TAG, "API getSearchWords request error: ${it.message}")
            })
        disposable.let { compositeDisposable.add(disposable as Disposable) }
    }

    protected fun finalize() {
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }
}
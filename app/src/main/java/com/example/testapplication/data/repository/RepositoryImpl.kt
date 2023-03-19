package com.example.testapplication.data.repository

import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import com.example.testapplication.data.datasource.local.LocalDataSource
import com.example.testapplication.data.datasource.remote.RemoteDataSource
import com.example.testapplication.data.mapper.Mapper
import com.example.testapplication.domain.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

private const val TAG = "API_REQUEST"

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val compositeDisposable: CompositeDisposable,
    private val mapper: Mapper
) : Repository {

    override fun getAllProducts(callback: (List<LatestProduct>, List<FlashSaleProduct>) -> Unit) {
        var latestProducts: List<LatestProduct> = mutableListOf()
        var flashSaleProduct: List<FlashSaleProduct> = mutableListOf()

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
        disposable.let { compositeDisposable.add(disposable as Disposable) }
    }

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        remoteDataSource.downloadProductImage(imageUrl, container)


    override fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) =
        remoteDataSource.downloadProductImageDrawable(imageUrl, callback)


    override fun getUserFormDb(firstName: String): User? = localDataSource.getUserFromDb(firstName)

    override fun writeUserInDb(user: User) = localDataSource.writeUserInDb(user)


    override fun getProductDetailInfo(callback: (ProductDetailInfo) -> Unit) {
        val disposable = remoteDataSource.getProductDetailInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback(it)
            }, {
                Log.i(TAG, "API getProductDetailInfo request error: ${it.message}")
            })
        disposable.let { compositeDisposable.add(disposable as Disposable) }
    }

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
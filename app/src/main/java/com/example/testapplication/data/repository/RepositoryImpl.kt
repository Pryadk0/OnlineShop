package com.example.testapplication.data.repository

import android.util.Log
import android.widget.ImageView
import com.example.testapplication.data.datasource.local.LocalDataSource
import com.example.testapplication.data.datasource.remote.RemoteDataSource
import com.example.testapplication.data.mapper.Mapper
import com.example.testapplication.domain.FlashSaleProduct
import com.example.testapplication.domain.LatestProduct
import com.example.testapplication.domain.Repository
import com.example.testapplication.domain.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

private const val TAG = "API_REQUEST"

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val mapper: Mapper
) : Repository {
    private var disposable: Disposable? = null

    override fun getAllProducts(callback: (List<LatestProduct>, List<FlashSaleProduct>) -> Unit) {
        var latestProducts: List<LatestProduct> = mutableListOf()
        var flashSaleProduct: List<FlashSaleProduct> = mutableListOf()

        disposable = remoteDataSource.getLatestProductsResponse()
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
                Log.i(TAG, "API request error: ${it.message}")
            })
    }

    override fun downloadProductImage(imageUrl: String, container: ImageView) {
        remoteDataSource.downloadProductImage(imageUrl, container)
    }

    override fun getUserFormDb(firstName: String): User? {
        return localDataSource.getUserFromDb(firstName)
    }

    override fun writeUserInDb(user: User) {
        localDataSource.writeUserInDb(user)
    }

    protected fun finalize() {
        disposable?.dispose()
    }
}
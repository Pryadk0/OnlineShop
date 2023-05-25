package com.example.testapplication.data.page1

import android.widget.ImageView
import com.example.testapplication.data.page1.datasources.Page1RemoteDataSource
import com.example.testapplication.data.page1.entities.FlashSaleProductDataEntity
import com.example.testapplication.data.page1.entities.LatestProductDataEntity
import javax.inject.Inject


class Page1DataRepositoryImpl @Inject constructor(
    private val remoteDataSource: Page1RemoteDataSource,
) : Page1DataRepository {

    override fun getAllProducts(
        callback: (List<LatestProductDataEntity>, List<FlashSaleProductDataEntity>) -> Unit
    ) = remoteDataSource.getAllProducts(callback)


    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        remoteDataSource.downloadProductImage(imageUrl, container)

    override fun getSearchWords(callback: (List<String>) -> Unit) =
        remoteDataSource.getSearchWords(callback)

}
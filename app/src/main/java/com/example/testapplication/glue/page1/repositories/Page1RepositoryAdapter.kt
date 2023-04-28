package com.example.testapplication.glue.page1.repositories

import android.widget.ImageView
import com.example.page1.Page1DataRepository
import com.example.page1.domain.entities.FlashSaleProduct
import com.example.page1.domain.entities.LatestProduct
import com.example.page1.domain.Page1Repository
import com.example.testapplication.glue.page1.mappers.Page1RepositoryAdapterMapper
import javax.inject.Inject

class Page1RepositoryAdapter @Inject constructor(
    private val dataRepository: Page1DataRepository,
    private val mapper: Page1RepositoryAdapterMapper
) : Page1Repository {

    override fun getAllProducts(callback: (List<LatestProduct>, List<FlashSaleProduct>) -> Unit) =
        dataRepository.getAllProducts { latestProductDataEntitiesList, flashSaleProductDataEntitiesList ->
            callback.invoke(
                mapper.mapLatestProductDataEntityListToLatestProductList(
                    latestProductDataEntitiesList
                ),
                mapper.mapFlashSaleProductDataEntityListToFlashSaleProductList(
                    flashSaleProductDataEntitiesList
                )
            )
        }

    override fun downloadProductImage(imageUrl: String, container: ImageView) =
        dataRepository.downloadProductImage(imageUrl, container)

    override fun getSearchWords(callback: (List<String>) -> Unit) =
        dataRepository.getSearchWords(callback)

}
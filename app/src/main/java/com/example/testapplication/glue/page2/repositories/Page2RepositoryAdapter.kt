package com.example.testapplication.glue.page2.repositories

import android.graphics.Bitmap
import com.example.testapplication.data.page2.Page2DataRepository
import com.example.testapplication.features.page2.domain.entities.ProductDetailInfo
import com.example.testapplication.features.page2.domain.Page2Repository
import com.example.testapplication.glue.page2.mappers.Page2RepositoryAdapterMapper
import javax.inject.Inject

class Page2RepositoryAdapter @Inject constructor(
    private val dataRepository: Page2DataRepository,
    private val mapper: Page2RepositoryAdapterMapper
) : Page2Repository {

    override fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) =
        dataRepository.downloadProductImageDrawable(imageUrl, callback)

    override fun getProductDetailInfo(callback: (ProductDetailInfo) -> Unit) =
        dataRepository.getProductDetailInfo { productDetailInfoDataEntity ->
            callback.invoke(
                mapper.mapProductDetailInfoDataEntityToProductDetailInfo(productDetailInfoDataEntity)
            )
        }

}
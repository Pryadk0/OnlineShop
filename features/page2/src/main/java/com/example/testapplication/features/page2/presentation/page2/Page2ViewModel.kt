package com.example.testapplication.features.page2.presentation.page2

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.features.page2.Page2Router
import com.example.testapplication.features.page2.domain.entities.ProductDetailInfo
import com.example.testapplication.features.page2.domain.usecases.DownloadProductImageUseCase
import com.example.testapplication.features.page2.domain.usecases.GetProductDetailInfoUseCase
import javax.inject.Inject

internal class Page2ViewModel @Inject constructor(
    private val getProductDetailInfoUseCase: GetProductDetailInfoUseCase,
    private val downloadProductImageUseCase: DownloadProductImageUseCase,
    private val page2Router: Page2Router
) : ViewModel() {
    private val _productDetailInfoLiveData: MutableLiveData<ProductDetailInfo> = MutableLiveData()
    val productDetailInfoLiveData: LiveData<ProductDetailInfo>
        get() = _productDetailInfoLiveData

    init {
        updateProductDetailInfoLiveData()
    }

    private fun updateProductDetailInfoLiveData() = getProductDetailInfoUseCase.getProductDetailInfo {
        _productDetailInfoLiveData.value = it
    }

    fun downloadProductImage(imageUrl: String, callback: (Bitmap?) -> Unit) =
        downloadProductImageUseCase.downloadProductImage(imageUrl, callback)

    fun startAuthorizedScreen(context: Context) {
        page2Router.startAuthorizedScreen(context)
    }
}
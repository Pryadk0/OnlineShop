package com.example.testapplication.features.page2.presentation.page2

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.features.page2.Page2Router
import com.example.testapplication.features.page2.domain.entities.ProductDetailInfo
import com.example.testapplication.features.page2.domain.usecases.DownloadProductImageDrawableUseCase
import com.example.testapplication.features.page2.domain.usecases.GetProductDetailInfoUseCase
import javax.inject.Inject

class Page2ViewModel @Inject constructor(
    private val getProductDetailInfoUseCase: GetProductDetailInfoUseCase,
    private val downloadProductImageDrawableUseCase: DownloadProductImageDrawableUseCase,
    private val page2Router: Page2Router
) : ViewModel() {
    private val _productDetailInfoLiveData: MutableLiveData<ProductDetailInfo> = MutableLiveData()
    val productDetailInfoLiveData: LiveData<ProductDetailInfo>
        get() = _productDetailInfoLiveData


    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) =
        downloadProductImageDrawableUseCase.downloadProductImageDrawable(imageUrl, callback)

    fun updateProductDetailInfoLiveData() = getProductDetailInfoUseCase.getProductDetailInfo {
        _productDetailInfoLiveData.value = it
    }

    fun startAuthorizedScreen(context: Context) {
        page2Router.startAuthorizedScreen(context)
    }
}
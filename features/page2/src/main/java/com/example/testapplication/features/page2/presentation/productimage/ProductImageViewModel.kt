package com.example.testapplication.features.page2.presentation.productimage

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.features.page2.domain.entities.ProductDetailInfo
import com.example.testapplication.features.page2.domain.usecases.DownloadProductImageUseCase
import javax.inject.Inject

internal class ProductImageViewModel @Inject constructor(
    private val downloadProductImageUseCase: DownloadProductImageUseCase
) : ViewModel() {
    private val _productDetailInfoLiveData: MutableLiveData<ProductDetailInfo> = MutableLiveData()
    val productDetailInfoLiveData: LiveData<ProductDetailInfo>
        get() = _productDetailInfoLiveData

    fun downloadProductImage(imageUrl: String, callback: (Bitmap?) -> Unit) =
        downloadProductImageUseCase.downloadProductImage(imageUrl, callback)

}
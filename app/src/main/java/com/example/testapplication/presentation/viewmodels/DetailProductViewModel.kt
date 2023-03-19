package com.example.testapplication.presentation.viewmodels

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.example.testapplication.domain.DownloadProductImageDrawableUseCase
import com.example.testapplication.domain.DownloadProductImageUseCase
import com.example.testapplication.domain.GetProductDetailInfoUseCase
import com.example.testapplication.domain.ProductDetailInfo
import javax.inject.Inject

class DetailProductViewModel @Inject constructor(
    private val downloadProductImageUseCase: DownloadProductImageUseCase,
    private val getProductDetailInfoUseCase: GetProductDetailInfoUseCase,
    private val downloadProductImageDrawableUseCase: DownloadProductImageDrawableUseCase
): ViewModel() {

    fun downloadProductImage(imageUrl: String, container: ImageView) {
        downloadProductImageUseCase.downloadProductImage(imageUrl, container)
    }

    fun downloadProductImageDrawable(imageUrl: String, callback: (Bitmap) -> Unit) {
        downloadProductImageDrawableUseCase.downloadProductImageDrawable(imageUrl, callback)
    }


    fun getProductDetailInfo(callback: (ProductDetailInfo) -> Unit) {
        getProductDetailInfoUseCase.getProductDetailInfo(callback)
    }
}
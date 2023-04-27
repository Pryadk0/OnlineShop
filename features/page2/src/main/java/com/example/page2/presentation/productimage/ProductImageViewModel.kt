package com.example.page2.presentation.productimage

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.page2.domain.entities.ProductDetailInfo
import com.example.page2.domain.usecases.DownloadProductImageUseCase
import javax.inject.Inject

class ProductImageViewModel @Inject constructor(
    private val downloadProductImageUseCase: DownloadProductImageUseCase
) : ViewModel() {
    private val _productDetailInfoLiveData: MutableLiveData<ProductDetailInfo> = MutableLiveData()
    val productDetailInfoLiveData: LiveData<ProductDetailInfo>
        get() = _productDetailInfoLiveData

    fun downloadProductImage(imageUrl: String, container: ImageView) =
        downloadProductImageUseCase.downloadProductImage(imageUrl, container)

}
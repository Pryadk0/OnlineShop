package com.example.testapplication.features.page1.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.features.page1.Page1Router
import com.example.testapplication.features.page1.domain.entities.FlashSaleProduct
import com.example.testapplication.features.page1.domain.entities.LatestProduct
import com.example.testapplication.features.page1.domain.usecases.GetAllProductsUseCase
import com.example.testapplication.features.page1.domain.usecases.GetSearchWordsUseCase
import javax.inject.Inject

internal class Page1ViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val getSearchWordsUseCase: GetSearchWordsUseCase,
    private val page1Router: Page1Router
) : ViewModel() {

    init {
        updateAllProductsLiveData()
    }

    private val _latestProductsLiveData: MutableLiveData<List<LatestProduct>> = MutableLiveData()
    val latestProductsLiveData: LiveData<List<LatestProduct>>
        get() = _latestProductsLiveData
    private val _flashSaleProductLiveData: MutableLiveData<List<FlashSaleProduct>> = MutableLiveData()
    val flashSaleProductLiveData: LiveData<List<FlashSaleProduct>>
        get() = _flashSaleProductLiveData

    private fun updateAllProductsLiveData() =
        getAllProductsUseCase.getAllProducts { latestProductsList, flashSaleProductsList ->
            _latestProductsLiveData.value = latestProductsList
            _flashSaleProductLiveData.value = flashSaleProductsList
        }

    fun getSearchWords(callback: (List<String>) -> Unit) =
        getSearchWordsUseCase.getSearchWords(callback)

    fun startFlashSaleProductDetailScreen(context: Context) =
        page1Router.startFlashSaleProductDetailScreen(context)
}
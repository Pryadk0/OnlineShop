package com.example.testapplication.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.domain.FlashSaleProduct
import com.example.testapplication.domain.GetAllProductsUseCase
import com.example.testapplication.domain.GetSearchWordsUseCase
import com.example.testapplication.domain.LatestProduct
import javax.inject.Inject

class AuthorizedViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val getSearchWordsUseCase: GetSearchWordsUseCase
) : ViewModel() {

    private val _latestProductsLiveData: MutableLiveData<List<LatestProduct>> = MutableLiveData()
    val latestProductsLiveData: LiveData<List<LatestProduct>>
        get() = _latestProductsLiveData
    private val _flashSaleProductLiveData: MutableLiveData<List<FlashSaleProduct>> =
        MutableLiveData()
    val flashSaleProductLiveData: LiveData<List<FlashSaleProduct>>
        get() = _flashSaleProductLiveData

    fun updateAllProductsLiveData() {
        getAllProductsUseCase.getAllProducts { latestProductsList, flashSaleProductsList ->
            _latestProductsLiveData.value = latestProductsList
            _flashSaleProductLiveData.value = flashSaleProductsList
        }
    }

    fun getSearchWords(callback: (List<String>) -> Unit) {
        getSearchWordsUseCase.getSearchWords(callback)
    }
}
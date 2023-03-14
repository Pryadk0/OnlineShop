package com.example.testapplication.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.testapplication.domain.FlashSaleProduct
import com.example.testapplication.domain.GetAllProductsUseCase
import com.example.testapplication.domain.LatestProduct
import javax.inject.Inject

class AuthorizedViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

    fun getAllProducts(callback: (List<LatestProduct>, List<FlashSaleProduct>) -> Unit) {
        getAllProductsUseCase.getAllProducts(callback)
    }
}
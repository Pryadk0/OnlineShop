package com.example.testapplication.glue.page1

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.testapplication.features.page1.Page1Router
import com.example.testapplication.presentation.activities.DetailProductActivity
import javax.inject.Inject

internal class Page1RouterImpl @Inject constructor() : Page1Router {

    override fun startFlashSaleProductDetailScreen(context: Context) {
        startActivity(context, Intent(context, DetailProductActivity::class.java), null)
    }
}
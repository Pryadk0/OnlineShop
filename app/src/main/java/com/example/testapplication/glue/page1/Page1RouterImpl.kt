package com.example.testapplication.glue.page1

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.page1.Page1Router
import com.example.testapplication.glue.activities.DetailProductActivity

class Page1RouterImpl : Page1Router {

    override fun startFlashSaleProductDetailScreen(context: Context) {
        startActivity(context, Intent(context, DetailProductActivity::class.java), null)
    }
}
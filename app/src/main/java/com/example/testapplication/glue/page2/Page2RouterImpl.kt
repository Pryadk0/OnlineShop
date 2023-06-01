package com.example.testapplication.glue.page2

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.testapplication.features.page2.Page2Router
import com.example.testapplication.presentation.activities.AuthorizedActivity
import javax.inject.Inject

internal class Page2RouterImpl @Inject constructor(): Page2Router {

    override fun startAuthorizedScreen(context: Context) {
        startActivity(context, Intent(context, AuthorizedActivity::class.java), null)
    }

}
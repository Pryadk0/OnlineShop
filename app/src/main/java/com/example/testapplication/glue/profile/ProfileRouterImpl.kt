package com.example.testapplication.glue.profile


import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.testapplication.features.profile.ProfileRouter
import com.example.testapplication.presentation.activities.AuthenticationActivity
import javax.inject.Inject

class ProfileRouterImpl @Inject constructor(): ProfileRouter {

    override fun startAuthenticationScreen(context: Context) {
        startActivity(context, Intent(context, AuthenticationActivity::class.java), null)
    }
}
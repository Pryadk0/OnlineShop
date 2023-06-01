package com.example.testapplication.features.profile.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.testapplication.features.profile.ProfileRouter
import javax.inject.Inject

internal class ProfileViewModel @Inject constructor(
    private val router: ProfileRouter
) : ViewModel() {

    fun startAuthenticationScreen(context: Context) =
        router.startAuthenticationScreen(context)

}
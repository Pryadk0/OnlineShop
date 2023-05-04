package com.example.profile.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.profile.ProfileRouter
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val router: ProfileRouter
) : ViewModel() {

    fun startAuthenticationScreen(context: Context) =
        router.startAuthenticationScreen(context)

}
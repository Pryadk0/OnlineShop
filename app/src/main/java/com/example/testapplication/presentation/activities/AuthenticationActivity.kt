package com.example.testapplication.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.core.theme.R
import com.example.testapplication.core.presentation.setStatusBarDarkIcons
import com.example.testapplication.databinding.ActivityAuthenticationBinding

internal class AuthenticationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthenticationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarDarkIcons(this.window, this, R.color.app_background)

    }
}
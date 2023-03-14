package com.example.testapplication.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.databinding.ActivityAuthenticationBinding
import com.example.testapplication.presentation.activities.utils.DarkStatusBarSetter

class AuthenticationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthenticationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DarkStatusBarSetter.setStatusBarDarkIcons(this.window, this)

    }
}
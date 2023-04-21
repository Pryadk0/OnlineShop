package com.example.testapplication.glue.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.R
import com.example.testapplication.databinding.ActivityAuthenticationBinding
import com.example.presentation.setStatusBarDarkIcons

class AuthenticationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthenticationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarDarkIcons(this.window, this, R.color.app_background)

    }
}
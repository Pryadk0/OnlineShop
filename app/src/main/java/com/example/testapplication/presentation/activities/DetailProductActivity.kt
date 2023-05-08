package com.example.testapplication.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.setStatusBarDarkIcons
import com.example.core.theme.R
import com.example.testapplication.databinding.ActivityDetailProductBinding

class DetailProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarDarkIcons(this.window, this, R.color.app_background)
    }

}
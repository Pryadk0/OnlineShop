package com.example.testapplication.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.databinding.ActivityDetailProductBinding
import com.example.testapplication.presentation.activities.utils.DarkStatusBarSetter

class DetailProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DarkStatusBarSetter.setStatusBarDarkIcons(this.window, this)
    }

}
package com.example.testapplication.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.example.testapplication.core.presentation.setStatusBarDarkIcons
import com.example.core.theme.R
import com.example.testapplication.databinding.ActivityAuthorizatedBinding
import com.example.testapplication.presentation.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class AuthorizedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthorizatedBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizatedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setStatusBarDarkIcons(this.window, this, R.color.app_background)
        initBottomTabNavigation()
        onBackPressedDispatcher.addCallback(this, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(applicationContext, AuthenticationActivity::class.java))
            }
        })
    }

    private fun initBottomTabNavigation() {
        viewPagerAdapter = ViewPagerAdapter(this)
        with(binding) {
            viewPagerAuthorized.adapter = viewPagerAdapter
            tabLayoutAuthorized.tabIconTint = null
            tabLayoutAuthorized.addOnTabSelectedListener(object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.icon?.colorFilter = BlendModeColorFilterCompat
                        .createBlendModeColorFilterCompat(
                            R.color.tab_layout_selected_icon,
                            BlendModeCompat.SRC_ATOP
                        )
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    tab?.icon?.colorFilter = null
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
        }
        TabLayoutMediator(
            binding.tabLayoutAuthorized,
            binding.viewPagerAuthorized
        ) { tab, position ->
            when (position) {
                0 -> tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_home)
                1 -> tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_heart)
                2 -> tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_cart)
                3 -> tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_messages)
                4 -> tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_profile)
            }
        }.attach()
    }
}
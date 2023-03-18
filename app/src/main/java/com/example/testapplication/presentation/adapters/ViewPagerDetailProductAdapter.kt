package com.example.testapplication.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testapplication.presentation.fragments.ProductImageFragment

class ViewPagerDetailProductAdapter(
    fragmentActivity: FragmentActivity,
    private val imageUrls: List<String>,
) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProductImageFragment.newInstance(imageUrls[0])
            1 -> ProductImageFragment.newInstance(imageUrls[1])
            2 -> ProductImageFragment.newInstance(imageUrls[2])
            else -> ProductImageFragment.newInstance(imageUrls[0])
        }
    }
}
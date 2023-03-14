package com.example.testapplication.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testapplication.presentation.fragments.Page1Fragment
import com.example.testapplication.presentation.fragments.ProfileFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Page1Fragment()
            //add more fragments when their number increase
            4 -> ProfileFragment()
            else -> Page1Fragment()
        }
    }
}
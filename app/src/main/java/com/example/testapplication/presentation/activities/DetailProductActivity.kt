package com.example.testapplication.presentation.activities

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testapplication.databinding.ActivityDetailProductBinding
import com.example.testapplication.presentation.TestApplication
import com.example.testapplication.presentation.activities.utils.DarkStatusBarSetter
import com.example.testapplication.presentation.adapters.ViewPagerDetailProductAdapter
import com.example.testapplication.presentation.viewmodels.DetailProductViewModel
import com.example.testapplication.presentation.viewmodels.ViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject

class DetailProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailProductBinding
    private val component by lazy {
        (application as TestApplication).component
    }
    private lateinit var viewPagerAdapter: ViewPagerDetailProductAdapter
    private val imageUrlsForTabs= mutableListOf<String>()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: DetailProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, viewModelFactory)[DetailProductViewModel::class.java]
        DarkStatusBarSetter.setStatusBarDarkIcons(this.window, this)


        /*viewModel.getProductDetailInfo {
            imageUrlsForTabs.addAll(it.imageUrls)
            imageUrlsForTabs.forEach { url ->
                viewModel.downloadProductImageDrawable(url) { bitmap ->
                    imagesForTabs.add(BitmapDrawable(resources, bitmap))
                }
            }*/


        viewModel.getProductDetailInfo {
            imageUrlsForTabs.addAll(it.imageUrls)
            viewPagerAdapter = ViewPagerDetailProductAdapter(this, it.imageUrls)
            with(binding) {
                viewPagerDetailProductActivity.adapter = viewPagerAdapter
                tabLayoutProductImages.tabIconTint = null
                tabLayoutProductImages.addOnTabSelectedListener(object :
                    TabLayout.OnTabSelectedListener {
                    override fun onTabSelected(tab: TabLayout.Tab?) {


                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {
                        /*tab?.icon?.colorFilter = null*/
                    }

                    override fun onTabReselected(tab: TabLayout.Tab?) {}
                })
            }
            TabLayoutMediator(
                binding.tabLayoutProductImages,
                binding.viewPagerDetailProductActivity
            ) { tab, position ->
                viewModel.downloadProductImageDrawable(imageUrlsForTabs[position]) { downloadedBitmap ->
                    runOnUiThread { tab.icon = BitmapDrawable(resources, downloadedBitmap) }
                }
            }.attach()
        }

    }


}
package com.example.testapplication.presentation.activities

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.testapplication.R
import com.example.testapplication.databinding.ActivityDetailProductBinding
import com.example.testapplication.databinding.ItemTabProductDetailImageBinding
import com.example.testapplication.domain.ProductDetailInfo
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

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: DetailProductViewModel
    private lateinit var viewPagerAdapter: ViewPagerDetailProductAdapter
    private lateinit var productDetailInfo: ProductDetailInfo
    private var sumInCart: Double = 0.00
    private var selectedColor = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DarkStatusBarSetter.setStatusBarDarkIcons(this.window, this)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailProductViewModel::class.java]
        viewModel.getProductDetailInfo {
            productDetailInfo = it
            initActivityViewsWithLoadedData()
            initViewPager()
            setCartControlButtonsOnClickListeners()
            setColorButtonsOnClickListeners()
            binding.imageButtonBackDetailProductActivity.setOnClickListener {
                startActivity(Intent(this, AuthorizedActivity::class.java))
            }
        }
    }

    private fun initActivityViewsWithLoadedData() {
        with(binding) {
            textViewDetailProductName.text = productDetailInfo.name
            textViewDetailProductPrice.text = String.format(
                getString(R.string.price_double_2_symbols_after_dot),
                productDetailInfo.price
            )
            textViewProductDescription.text = productDetailInfo.description
            textViewRatio.text = productDetailInfo.rating.toString()
            textViewReviews.text = String.format(
                getString(R.string.text_view_number_of_reviews),
                productDetailInfo.numberOfReviews
            )
            cardViewColor1.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(productDetailInfo.colors[0]))
            cardViewColor2.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(productDetailInfo.colors[1]))
            cardViewColor3.backgroundTintList =
                ColorStateList.valueOf(Color.parseColor(productDetailInfo.colors[2]))
            textViewSumInCart.text = String.format(
                getString(R.string.price_double_2_symbols_after_dot),
                productDetailInfo.price
            )
        }
    }

    private fun initViewPager() {
        viewPagerAdapter = ViewPagerDetailProductAdapter(this, productDetailInfo)
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
            val customTab: ItemTabProductDetailImageBinding = DataBindingUtil.inflate(
                LayoutInflater.from(binding.tabLayoutProductImages.context),
                R.layout.item_tab_product_detail_image, binding.tabLayoutProductImages,
                false
            )
            viewModel.downloadProductImageDrawable(productDetailInfo.imageUrls[position]) { downloadedBitmap ->
                runOnUiThread {
                    customTab.imageViewTabItemProductDetail.setImageBitmap(downloadedBitmap)
                    tab.customView = customTab.root
                }
            }
        }.attach()
    }

    private fun setCartControlButtonsOnClickListeners() {
        sumInCart = productDetailInfo.price
        binding.imageButtonQuantityPlus.setOnClickListener { buttonPlus ->
            buttonPlus.isEnabled = false
            sumInCart += productDetailInfo.price
            binding.textViewSumInCart.text =
                String.format(getString(R.string.price_double_2_symbols_after_dot), sumInCart)
            buttonPlus.isEnabled = true
        }

        binding.imageButtonQuantityMinus.setOnClickListener { buttonMinus ->
            buttonMinus.isEnabled = false
            if (sumInCart > 0) {
                sumInCart -= productDetailInfo.price
                binding.textViewSumInCart.text = String.format(
                    getString(R.string.price_double_2_symbols_after_dot),
                    sumInCart
                )
            }
            buttonMinus.isEnabled = true
        }
    }

    private fun setColorButtonsOnClickListeners() {
        binding.cardViewColor1.setOnClickListener {
            if (selectedColor != 1) {
                selectedColor = 1
                binding.cardViewColor1SelectedState.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.selected_color_background))
                binding.cardViewColor2SelectedState.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.app_background))
                binding.cardViewColor3SelectedState.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.app_background))
            }
        }
        binding.cardViewColor2.setOnClickListener {
            if (selectedColor != 2) {
                selectedColor = 2
                binding.cardViewColor2SelectedState.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.selected_color_background))
                binding.cardViewColor1SelectedState.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.app_background))
                binding.cardViewColor3SelectedState.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.app_background))
            }
        }
        binding.cardViewColor3.setOnClickListener {
            if (selectedColor != 3) {
                selectedColor = 3
                binding.cardViewColor3SelectedState.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.selected_color_background))
                binding.cardViewColor1SelectedState.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.app_background))
                binding.cardViewColor2SelectedState.backgroundTintList =
                    ColorStateList.valueOf(getColor(R.color.app_background))
            }
        }
    }
}
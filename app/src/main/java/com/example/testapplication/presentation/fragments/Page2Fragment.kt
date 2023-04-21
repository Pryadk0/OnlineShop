package com.example.testapplication.presentation.fragments

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testapplication.R
import com.example.testapplication.databinding.FragmentPage2Binding
import com.example.testapplication.databinding.ItemTabProductDetailImageBinding
import com.example.testapplication.domain.ProductDetailInfo
import com.example.testapplication.glue.TestApplication
import com.example.testapplication.glue.activities.AuthorizedActivity
import com.example.testapplication.presentation.adapters.ViewPagerDetailProductAdapter
import com.example.testapplication.presentation.viewmodels.DetailProductViewModel
import com.example.testapplication.presentation.viewmodels.ViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject


class Page2Fragment : Fragment() {
    private var _binding: FragmentPage2Binding? = null
    private val binding: FragmentPage2Binding
        get() = _binding ?: throw RuntimeException("${this.javaClass.simpleName}Binding == null")

    private val component by lazy {
        (requireActivity().application as TestApplication).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: DetailProductViewModel
    private lateinit var viewPagerAdapter: ViewPagerDetailProductAdapter
    private lateinit var productDetailInfo: ProductDetailInfo
    private var sumInCart: Double = 0.00
    private var selectedColor = 1


    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPage2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory)[DetailProductViewModel::class.java]
        viewModel.updateProductDetailInfoLiveData()
        viewModel.productDetailInfoLiveData.observe(viewLifecycleOwner) {
            productDetailInfo = it
            initActivityViewsWithLoadedData()
            initViewPager()
            setCartControlButtonsOnClickListeners()
            setColorButtonsOnClickListeners()
            setBackButtonsListeners()
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
        viewPagerAdapter = ViewPagerDetailProductAdapter(requireActivity(), productDetailInfo)
        with(binding) {
            viewPagerFragmentPage2.adapter = viewPagerAdapter
            tabLayoutProductImages.tabIconTint = null
            tabLayoutProductImages.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when (tab?.position) {
                        0 -> run {
                            val checkedInitialDrawable: Drawable? =
                                tab.customView?.findViewById<ImageView>(R.id.image_view_tab_item_product_detail)?.drawable
                            checkedInitialDrawable?.let {
                                binding.imageViewTabItemProductDetailSelected1.setImageDrawable(
                                    checkedInitialDrawable
                                )
                                binding.cardViewTabItemProductDetailSelected1.visibility =
                                    View.VISIBLE
                            }
                        }
                        1 -> run {
                            val checkedInitialDrawable: Drawable? =
                                tab.customView?.findViewById<ImageView>(R.id.image_view_tab_item_product_detail)?.drawable
                            checkedInitialDrawable?.let {
                                binding.imageViewTabItemProductDetailSelected2.setImageDrawable(
                                    checkedInitialDrawable
                                )
                                binding.cardViewTabItemProductDetailSelected2.visibility =
                                    View.VISIBLE
                            }
                        }
                        2 -> run {
                            val checkedInitialDrawable: Drawable? =
                                tab.customView?.findViewById<ImageView>(R.id.image_view_tab_item_product_detail)?.drawable
                            checkedInitialDrawable?.let {
                                binding.imageViewTabItemProductDetailSelected3.setImageDrawable(
                                    checkedInitialDrawable
                                )
                                binding.cardViewTabItemProductDetailSelected3.visibility =
                                    View.VISIBLE
                            }
                        }
                    }

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    when (tab?.position) {
                        0 -> binding.cardViewTabItemProductDetailSelected1.visibility =
                            View.INVISIBLE
                        1 -> binding.cardViewTabItemProductDetailSelected2.visibility =
                            View.INVISIBLE
                        2 -> binding.cardViewTabItemProductDetailSelected3.visibility =
                            View.INVISIBLE

                    }
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
        }

        TabLayoutMediator(
            binding.tabLayoutProductImages,
            binding.viewPagerFragmentPage2
        ) { tab, position ->
            val customTab: ItemTabProductDetailImageBinding = DataBindingUtil.inflate(
                LayoutInflater.from(binding.tabLayoutProductImages.context),
                R.layout.item_tab_product_detail_image, binding.tabLayoutProductImages,
                false
            )
            viewModel.downloadProductImageDrawable(productDetailInfo.imageUrls[position]) { downloadedBitmap ->
                requireActivity().runOnUiThread {
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
                    ColorStateList.valueOf(requireContext().getColor(R.color.selected_color_background))
                binding.cardViewColor2SelectedState.backgroundTintList =
                    ColorStateList.valueOf(requireContext().getColor(R.color.app_background))
                binding.cardViewColor3SelectedState.backgroundTintList =
                    ColorStateList.valueOf(requireContext().getColor(R.color.app_background))
            }
        }
        binding.cardViewColor2.setOnClickListener {
            if (selectedColor != 2) {
                selectedColor = 2
                binding.cardViewColor2SelectedState.backgroundTintList =
                    ColorStateList.valueOf(requireContext().getColor(R.color.selected_color_background))
                binding.cardViewColor1SelectedState.backgroundTintList =
                    ColorStateList.valueOf(requireContext().getColor(R.color.app_background))
                binding.cardViewColor3SelectedState.backgroundTintList =
                    ColorStateList.valueOf(requireContext().getColor(R.color.app_background))
            }
        }
        binding.cardViewColor3.setOnClickListener {
            if (selectedColor != 3) {
                selectedColor = 3
                binding.cardViewColor3SelectedState.backgroundTintList =
                    ColorStateList.valueOf(requireContext().getColor(R.color.selected_color_background))
                binding.cardViewColor1SelectedState.backgroundTintList =
                    ColorStateList.valueOf(requireContext().getColor(R.color.app_background))
                binding.cardViewColor2SelectedState.backgroundTintList =
                    ColorStateList.valueOf(requireContext().getColor(R.color.app_background))
            }
        }
    }

    private fun setBackButtonsListeners() {
        binding.imageButtonBackFragmentPage2.setOnClickListener {
            startActivity(Intent(context, AuthorizedActivity::class.java))
        }
        requireActivity()
            .onBackPressedDispatcher.addCallback(
                viewLifecycleOwner,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        startActivity(Intent(context, AuthorizedActivity::class.java))
                    }
                })
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
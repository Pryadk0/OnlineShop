package com.example.testapplication.features.page2.presentation.productimage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.features.page2.R
import com.example.features.page2.databinding.FragmentProductImageBinding
import com.example.testapplication.features.page2.di.component.Page2ComponentDependencies
import com.example.testapplication.features.page2.di.component.Page2ComponentDependenciesProvider
import com.example.testapplication.features.page2.di.component.ProductImageFragmentComponentViewModel
import com.example.testapplication.core.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

private const val ARG_IMAGE_URL = "imageUrl"

class ProductImageFragment : Fragment(R.layout.fragment_product_image) {
    private var _binding: FragmentProductImageBinding? = null
    private val binding: FragmentProductImageBinding
        get() = _binding ?: throw RuntimeException("${this.javaClass.simpleName}Binding == null")

    private var imageIrl: String? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: ProductImageViewModel

    override fun onAttach(context: Context) {
        val dependencies: Page2ComponentDependencies =
            (context.applicationContext as Page2ComponentDependenciesProvider).getPage2ComponentDependencies()
        ViewModelProvider(this)[ProductImageFragmentComponentViewModel::class.java]
            .newPage2Component(dependencies)
            .injectProductImageFragment(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageIrl = it.getString(ARG_IMAGE_URL)
        }
        viewModel = ViewModelProvider(this, viewModelFactory)[ProductImageViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageIrl?.let {
            viewModel.downloadProductImage(it, binding.imageViewDetailProductImage)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(imageUrl: String) =
            ProductImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_IMAGE_URL, imageUrl)
                }
            }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
package com.example.testapplication.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testapplication.databinding.FragmentProductImageBinding
import com.example.testapplication.presentation.TestApplication
import com.example.testapplication.presentation.viewmodels.DetailProductViewModel
import com.example.testapplication.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject

private const val ARG_IMAGE_URL = "imageUrl"

class ProductImageFragment : Fragment() {
    private var _binding: FragmentProductImageBinding? = null
    private val binding: FragmentProductImageBinding
        get() = _binding ?: throw RuntimeException("${this.javaClass.simpleName}Binding == null")
    private val component by lazy {
        (requireActivity().application as TestApplication).component
    }
    private var imageIrl: String? = null
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: DetailProductViewModel

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageIrl = it.getString(ARG_IMAGE_URL)
        }
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailProductViewModel::class.java]
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
package com.example.testapplication.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.databinding.FragmentPage1Binding
import com.example.testapplication.presentation.TestApplication
import com.example.testapplication.presentation.adapters.FlashSaleProductsAdapter
import com.example.testapplication.presentation.adapters.LatestProductsAdapter
import com.example.testapplication.presentation.viewmodels.AuthorizedViewModel
import com.example.testapplication.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject


class Page1Fragment : Fragment() {
    private var _binding: FragmentPage1Binding? = null
    private val binding: FragmentPage1Binding
        get() = _binding ?: throw RuntimeException("${this.javaClass.simpleName}Binding == null")

    private val component by lazy {
        (requireActivity().application as TestApplication).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var flashSaleProductAdapter: FlashSaleProductsAdapter
    @Inject
    lateinit var latestProductAdapter: LatestProductsAdapter


    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPage1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.recyclerViewLatest) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = latestProductAdapter
        }

        with(binding.recyclerViewFlashSale) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = flashSaleProductAdapter
        }

        val viewModel = ViewModelProvider(this, viewModelFactory)[AuthorizedViewModel::class.java]
        viewModel.getAllProducts { latestProducts, flashSaleProducts ->
            Log.i(
                "TEST",
                "latest product #0 : ${latestProducts[0].name}, ${latestProducts[0].category}, ${latestProducts[0].imageUrl}, ${latestProducts[0].price}"
            )
            Log.i(
                "TEST",
                "flash sale product #0 : ${flashSaleProducts[1].name}, ${flashSaleProducts[1].category}, ${flashSaleProducts[1].imageUrl}, ${flashSaleProducts[1].price}, ${flashSaleProducts[1].discount}"
            )

            latestProductAdapter.submitList(latestProducts)
            flashSaleProductAdapter.submitList(flashSaleProducts)
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
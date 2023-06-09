package com.example.testapplication.features.page1.presentation

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.features.page1.R
import com.example.features.page1.databinding.FragmentPage1Binding
import com.example.testapplication.core.presentation.viewmodel.ViewModelFactory
import com.example.testapplication.features.page1.di.component.Page1ComponentDependencies
import com.example.testapplication.features.page1.di.component.Page1ComponentDependenciesProvider
import com.example.testapplication.features.page1.di.component.Page1ComponentViewModel
import com.example.testapplication.features.page1.presentation.adapters.FlashSaleProductsAdapter
import com.example.testapplication.features.page1.presentation.adapters.LatestProductsAdapter
import javax.inject.Inject


class Page1Fragment : Fragment(R.layout.fragment_page1) {
    private var _binding: FragmentPage1Binding? = null
    private val binding: FragmentPage1Binding
        get() = _binding ?: throw RuntimeException("${this.javaClass.simpleName}Binding == null")

    private lateinit var viewModel: Page1ViewModel

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    @Inject
    internal lateinit var flashSaleProductAdapter: FlashSaleProductsAdapter

    @Inject
    internal lateinit var latestProductAdapter: LatestProductsAdapter

    override fun onAttach(context: Context) {
        val componentDependencies: Page1ComponentDependencies =
            (context.applicationContext as Page1ComponentDependenciesProvider).getPage1ComponentDependencies()
        ViewModelProvider(this)[Page1ComponentViewModel::class.java]
            .newPage1Component(componentDependencies)
            .injectPage1Fragment(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPage1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[Page1ViewModel::class.java]
        initRecyclerViews()
        setOnClickListeners()
        setAutoCompletableTextViewCompletionHints()
    }

    private fun initRecyclerViews() {
        with(binding.recyclerViewLatest) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = latestProductAdapter
        }
        with(binding.recyclerViewFlashSale) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = flashSaleProductAdapter
        }
        with(viewModel) {
            latestProductsLiveData.observe(viewLifecycleOwner) {
                latestProductAdapter.submitList(it)
            }
            flashSaleProductLiveData.observe(viewLifecycleOwner) {
                flashSaleProductAdapter.submitList(it)
            }
        }
    }

    private fun setOnClickListeners() {
        flashSaleProductAdapter.onFlashSaleProductCLickListener = { _ ->
            //get data from clicked item to open the screen with item detail info
            viewModel.startFlashSaleProductDetailScreen(requireContext())
        }
    }

    private fun setAutoCompletableTextViewCompletionHints() {
        val arrayAdapter =
            ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1)
        with(binding.autoCompletableTextViewSearchFragmentPage1) {
            setAdapter(arrayAdapter)
            afterTextChangedDelayed { text ->
                if (text.isNotEmpty()) {
                    viewModel.getSearchWords { wordsList ->
                        val filteredWordList = wordsList.filter { word ->
                            word.contains(Regex("(?i)$text"))
                        }
                        if (!arrayAdapter.isEmpty) arrayAdapter.clear()
                        arrayAdapter.addAll(filteredWordList)
                        arrayAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    private fun AutoCompleteTextView.afterTextChangedDelayed(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            var timer: CountDownTimer? = null

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                timer?.cancel()
                timer = object : CountDownTimer(1000, 1500) {
                    override fun onTick(millisUntilFinished: Long) {}
                    override fun onFinish() {
                        afterTextChanged.invoke(editable.toString())
                    }
                }.start()
            }
        })
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
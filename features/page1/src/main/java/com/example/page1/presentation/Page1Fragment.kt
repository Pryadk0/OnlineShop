package com.example.page1.presentation

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
import com.example.page1.R
import com.example.page1.databinding.FragmentPage1Binding
import com.example.page1.presentation.adapters.FlashSaleProductsAdapter
import com.example.page1.presentation.adapters.LatestProductsAdapter
import com.example.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject


class Page1Fragment : Fragment(R.layout.fragment_page1) {
    private var _binding: FragmentPage1Binding? = null
    private val binding: FragmentPage1Binding
        get() = _binding ?: throw RuntimeException("${this.javaClass.simpleName}Binding == null")

    private val component by lazy {
        (requireActivity().application as TestApplication).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: Page1ViewModel

    @Inject
    lateinit var flashSaleProductAdapter: FlashSaleProductsAdapter

    @Inject
    lateinit var latestProductAdapter: LatestProductsAdapter

    override fun onAttach(context: Context) {
        component.inject(this)
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

        with(binding.recyclerViewLatest) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = latestProductAdapter
        }

        with(binding.recyclerViewFlashSale) {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            adapter = flashSaleProductAdapter
        }

        viewModel = ViewModelProvider(this, viewModelFactory)[Page1ViewModel::class.java]
        with(viewModel){
            updateAllProductsLiveData()
            latestProductsLiveData.observe(viewLifecycleOwner) {
                latestProductAdapter.submitList(it)
            }
            flashSaleProductLiveData.observe(viewLifecycleOwner) {
                flashSaleProductAdapter.submitList(it)
            }
        }
        flashSaleProductAdapter.onFlashSaleProductCLickListener = { _ ->
            //get data from clicked item to open the screen with item detail info
            viewModel.startFlashSaleProductDetailScreen(requireContext())
        }

        setAutoCompletableTextViewCompletionHints()
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
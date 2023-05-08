package com.example.testapplication.features.page1.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.features.page1.databinding.ItemLatestProductBinding
import com.example.testapplication.features.page1.domain.entities.LatestProduct
import com.example.testapplication.features.page1.domain.usecases.DownloadProductImageUseCase
import javax.inject.Inject

class LatestProductsAdapter @Inject constructor(
    private val downloadProductImageUseCase: DownloadProductImageUseCase
) : ListAdapter<LatestProduct, LatestProductsAdapter.LatestProductsViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<LatestProduct> =
            LatestProductsItemDiffCallback()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestProductsViewHolder {
        return LatestProductsViewHolder(
            ItemLatestProductBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: LatestProductsViewHolder, position: Int) {
        downloadProductImageUseCase.downloadProductImage(
            currentList[position].imageUrl,
            holder.binding.imageViewItemLatestBackground
        )
        with(holder.binding) {
            textViewItemLatestName.text = currentList[position].name
            textViewItemLatestPrice.text =
                String.format(
                    holder.itemView.context.getString(com.example.core.theme.R.string.recycler_view_latest_products_item_price),
                    currentList[position].price
                ).replace(".", ",")
            textViewItemLatestCategory.text = currentList[position].category
        }
    }


    inner class LatestProductsViewHolder(val binding: ItemLatestProductBinding) :
        RecyclerView.ViewHolder(binding.root)
}
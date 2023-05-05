package com.example.page1.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.features.page1.databinding.ItemFlashSaleProductBinding
import com.example.page1.domain.entities.FlashSaleProduct
import com.example.page1.domain.usecases.DownloadProductImageUseCase
import javax.inject.Inject

class FlashSaleProductsAdapter @Inject constructor(
    private val downloadProductImageUseCase: DownloadProductImageUseCase
) : ListAdapter<FlashSaleProduct, FlashSaleProductsAdapter.FlashSaleProductsViewHolder>(
    DIFF_CALLBACK
) {
    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<FlashSaleProduct> =
            FlashSaleProductItemDiffCallback()
    }

    var onFlashSaleProductCLickListener: ((position: Int) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): FlashSaleProductsViewHolder {
        return FlashSaleProductsViewHolder(
            ItemFlashSaleProductBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: FlashSaleProductsViewHolder, position: Int) {
        downloadProductImageUseCase.downloadProductImage(
            currentList[position].imageUrl, holder.binding.imageViewItemFlashSaleBackground
        )
        with(holder.binding) {
            textViewItemFlashSaleName.text = currentList[position].name
            textViewItemFlashSalePrice.text =
                String.format(
                    holder.itemView.context.getString(com.example.core.theme.R.string.price_double_2_symbols_after_dot),
                    currentList[position].price
                ).replace(".", ",")
            textViewItemLatestCategory.text = currentList[position].category
            textViewItemFlashSaleDiscount.text =
                String.format(
                    holder.itemView.context.getString(com.example.core.theme.R.string.recycler_view_flash_sale_products_item_discount),
                    currentList[position].discount
                ).replace(".", ",")
        }
    }


    inner class FlashSaleProductsViewHolder(val binding: ItemFlashSaleProductBinding) :
        ViewHolder(binding.root) {
        init {
            binding.imageViewItemFlashSaleBackground.setOnClickListener {
                onFlashSaleProductCLickListener?.invoke(adapterPosition)
            }
        }
    }

}
package com.example.page1.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.page1.domain.entities.FlashSaleProduct

class FlashSaleProductItemDiffCallback :DiffUtil.ItemCallback<FlashSaleProduct>() {
    override fun areItemsTheSame(oldItem: FlashSaleProduct, newItem: FlashSaleProduct): Boolean =
        oldItem.imageUrl == newItem.imageUrl

    override fun areContentsTheSame(oldItem: FlashSaleProduct, newItem: FlashSaleProduct): Boolean =
        oldItem == newItem
}
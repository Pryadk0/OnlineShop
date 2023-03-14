package com.example.testapplication.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.testapplication.domain.FlashSaleProduct

class FlashSaleProductItemDiffCallback :DiffUtil.ItemCallback<FlashSaleProduct>() {
    override fun areItemsTheSame(oldItem: FlashSaleProduct, newItem: FlashSaleProduct): Boolean =
        oldItem.imageUrl == newItem.imageUrl

    override fun areContentsTheSame(oldItem: FlashSaleProduct, newItem: FlashSaleProduct): Boolean =
        oldItem == newItem
}
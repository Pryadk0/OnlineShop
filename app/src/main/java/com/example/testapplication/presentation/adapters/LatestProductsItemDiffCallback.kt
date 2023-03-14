package com.example.testapplication.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.testapplication.domain.LatestProduct

class LatestProductsItemDiffCallback : DiffUtil.ItemCallback<LatestProduct>() {
    override fun areItemsTheSame(oldItem: LatestProduct, newItem: LatestProduct): Boolean =
        oldItem.imageUrl == newItem.imageUrl

    override fun areContentsTheSame(oldItem: LatestProduct, newItem: LatestProduct): Boolean =
        oldItem == newItem
}
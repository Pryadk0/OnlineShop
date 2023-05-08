package com.example.testapplication.features.page1.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.testapplication.features.page1.domain.entities.LatestProduct

class LatestProductsItemDiffCallback : DiffUtil.ItemCallback<LatestProduct>() {
    override fun areItemsTheSame(oldItem: LatestProduct, newItem: LatestProduct): Boolean =
        oldItem.imageUrl == newItem.imageUrl

    override fun areContentsTheSame(oldItem: LatestProduct, newItem: LatestProduct): Boolean =
        oldItem == newItem
}
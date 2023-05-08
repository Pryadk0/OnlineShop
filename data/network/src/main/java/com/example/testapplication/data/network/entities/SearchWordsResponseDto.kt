package com.example.testapplication.data.network.entities

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SearchWordsResponseDto(
    @SerializedName("words")
    @Expose
    val words: List<String>
)
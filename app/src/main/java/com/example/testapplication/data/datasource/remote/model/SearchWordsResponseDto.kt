package com.example.testapplication.data.datasource.remote.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SearchWordsResponseDto(
    @SerializedName("words")
    @Expose
    val words: List<String>
)
package com.example.testapplication.features.page1.domain.usecases

internal interface GetSearchWordsUseCase {

    fun getSearchWords(callback: (List<String>) -> Unit)

}
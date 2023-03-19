package com.example.testapplication.domain

import javax.inject.Inject

class GetSearchWordsUseCase @Inject constructor(private val repository: Repository) {

    fun getSearchWords(callback: (List<String>) -> Unit) =
        repository.getSearchWords(callback)
}
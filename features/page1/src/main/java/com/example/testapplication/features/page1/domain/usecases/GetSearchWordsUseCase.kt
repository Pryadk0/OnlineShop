package com.example.testapplication.features.page1.domain.usecases

import com.example.testapplication.features.page1.domain.Page1Repository
import javax.inject.Inject

class GetSearchWordsUseCase @Inject constructor(private val repository: Page1Repository) {

    fun getSearchWords(callback: (List<String>) -> Unit) =
        repository.getSearchWords(callback)
}
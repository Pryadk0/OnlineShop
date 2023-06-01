package com.example.testapplication.features.page1.domain.usecases.impl

import com.example.testapplication.features.page1.domain.Page1Repository
import com.example.testapplication.features.page1.domain.usecases.GetSearchWordsUseCase
import javax.inject.Inject

internal class GetSearchWordsUseCaseImpl @Inject constructor(private val repository: Page1Repository) :
    GetSearchWordsUseCase {

    override fun getSearchWords(callback: (List<String>) -> Unit) =
        repository.getSearchWords(callback)

}
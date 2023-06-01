package com.example.testapplication.features.page1.di.component

import androidx.lifecycle.ViewModel

internal class Page1ComponentViewModel : ViewModel() {

    private var page1Component: Page1Component? = null

    fun newPage1Component(dependencies: Page1ComponentDependencies): Page1Component {
        page1Component = DaggerPage1Component.builder().componentDependencies(dependencies).build()
        page1Component?.let { return it }
        throw RuntimeException("Page1Component == null")
    }

    override fun onCleared() {
        page1Component = null
        super.onCleared()
    }

}
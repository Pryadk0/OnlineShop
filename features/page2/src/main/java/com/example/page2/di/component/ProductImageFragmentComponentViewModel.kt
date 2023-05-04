package com.example.page2.di.component

import androidx.lifecycle.ViewModel
import java.lang.RuntimeException

class ProductImageFragmentComponentViewModel: ViewModel() {

    private var component: Page2Component? = null

    fun newPage2Component(dependencies: Page2ComponentDependencies) : Page2Component {
        component = DaggerPage2Component.builder().componentDependencies(dependencies).build()
        component?.let { return it }
        throw RuntimeException("Page2Component == null")
    }

    override fun onCleared() {
        component = null
        super.onCleared()
    }
}
package com.example.testapplication.features.profile.di.component

import androidx.lifecycle.ViewModel
import java.lang.RuntimeException

class ProfileComponentViewModel : ViewModel() {

    private var component: ProfileComponent? = null

    fun newProfileComponent(dependencies: ProfileComponentDependencies): ProfileComponent {
        component = DaggerProfileComponent.builder().componentDependencies(dependencies).build()
        component?.let { return it }
        throw RuntimeException("ProfileComponent == null")
    }

    override fun onCleared() {
        component = null
        super.onCleared()
    }
}
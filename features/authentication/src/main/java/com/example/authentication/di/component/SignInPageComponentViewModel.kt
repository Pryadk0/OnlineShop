package com.example.authentication.di.component

import androidx.lifecycle.ViewModel

class SignInPageComponentViewModel: ViewModel() {

    private var component: AuthenticationComponent? = null

    fun newAuthenticationComponent(dependencies: AuthenticationComponentDependencies): AuthenticationComponent {
        component =
            DaggerAuthenticationComponent.builder().componentDependencies(dependencies).build()
        component?.let { return it }
        throw RuntimeException("AuthenticationComponent == null")
    }

    override fun onCleared() {
        component = null
        super.onCleared()
    }
}
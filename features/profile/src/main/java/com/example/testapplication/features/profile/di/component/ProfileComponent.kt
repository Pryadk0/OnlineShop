package com.example.testapplication.features.profile.di.component

import com.example.testapplication.features.profile.di.modules.ProfileViewModelModule
import com.example.testapplication.features.profile.di.scopes.ProfileFeatureScope
import com.example.testapplication.features.profile.presentation.ProfileFragment
import dagger.Component

@ProfileFeatureScope
@Component(
    modules = [ProfileViewModelModule::class],
    dependencies = [ProfileComponentDependencies::class]
)
internal interface ProfileComponent {

    fun injectProfileFragment(profileFragment: ProfileFragment)

    @Component.Builder
    interface Builder {

        fun componentDependencies(dependencies: ProfileComponentDependencies): Builder

        fun build(): ProfileComponent
    }

}
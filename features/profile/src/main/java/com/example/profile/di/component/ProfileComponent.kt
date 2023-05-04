package com.example.profile.di.component

import com.example.profile.di.modules.ProfileViewModelModule
import com.example.profile.di.scopes.ProfileFeatureScope
import com.example.profile.presentation.ProfileFragment
import dagger.Component

@ProfileFeatureScope
@Component(
    modules = [ProfileViewModelModule::class],
    dependencies = [ProfileComponentDependencies::class]
)
interface ProfileComponent {

    fun injectProfileFragment(profileFragment: ProfileFragment)

    @Component.Builder
    interface Builder {

        fun componentDependencies(dependencies: ProfileComponentDependencies): Builder

        fun build(): ProfileComponent
    }

}
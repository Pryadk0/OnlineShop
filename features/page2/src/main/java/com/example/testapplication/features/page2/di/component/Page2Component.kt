package com.example.testapplication.features.page2.di.component

import com.example.testapplication.features.page2.di.modules.Page2ViewModelModule
import com.example.testapplication.features.page2.di.scopes.Page2FeatureScope
import com.example.testapplication.features.page2.presentation.page2.Page2Fragment
import com.example.testapplication.features.page2.presentation.productimage.ProductImageFragment
import dagger.Component

@Page2FeatureScope
@Component(
    modules = [Page2ViewModelModule::class],
    dependencies = [Page2ComponentDependencies::class]
)
interface Page2Component {

    fun injectPage2Fragment(page2Fragment: Page2Fragment)

    fun injectProductImageFragment(productImageFragment: ProductImageFragment)

    @Component.Builder
    interface Builder {

        fun componentDependencies(dependencies: Page2ComponentDependencies): Builder

        fun build(): Page2Component
    }
}
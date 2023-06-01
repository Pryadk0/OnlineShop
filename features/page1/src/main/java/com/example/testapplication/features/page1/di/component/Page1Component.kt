package com.example.testapplication.features.page1.di.component

import com.example.testapplication.features.page1.di.modules.Page1ViewModelModule
import com.example.testapplication.features.page1.di.scope.Page1FeatureScope
import com.example.testapplication.features.page1.presentation.Page1Fragment
import dagger.Component

@Page1FeatureScope
@Component(
    modules = [Page1ViewModelModule::class],
    dependencies = [Page1ComponentDependencies::class]
)
internal interface Page1Component {

    fun injectPage1Fragment(page1Fragment: Page1Fragment)

    @Component.Builder
    interface Builder {

        fun componentDependencies(dependencies: Page1ComponentDependencies): Builder

        fun build(): Page1Component
    }
}
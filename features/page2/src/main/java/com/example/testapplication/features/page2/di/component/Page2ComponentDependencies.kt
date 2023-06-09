package com.example.testapplication.features.page2.di.component

import com.example.testapplication.features.page2.Page2Router
import com.example.testapplication.features.page2.domain.Page2Repository

interface Page2ComponentDependencies {

    fun getPage2Router(): Page2Router

    fun getPage2Repository(): Page2Repository

}
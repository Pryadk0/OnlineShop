package com.example.page1.di.component

import com.example.page1.Page1Router
import com.example.page1.domain.Page1Repository

interface Page1ComponentDependencies {

    fun getPage1Router(): Page1Router

    fun getPage1Repository(): Page1Repository

}
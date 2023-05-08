package com.example.testapplication.features.profile.di.component

import com.example.testapplication.features.profile.ProfileRouter

interface ProfileComponentDependencies {

    fun getProfileRouter(): ProfileRouter
}
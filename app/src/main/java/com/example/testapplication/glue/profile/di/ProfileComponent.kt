package com.example.testapplication.glue.profile.di

import com.example.network.ApiService
import dagger.Component

@Component(modules = [ProfileModule::class], dependencies = [ProfileComponentDependencies::class])
@ProfileScope
interface ProfileComponent {


}

interface ProfileComponentDependencies {
    //fun getSmth(): Smth подобными функциями перечислить объекты
    //которые нужны ProfileComponent из AppComponent для своей работы:

    fun getApiService(): com.example.network.ApiService
}
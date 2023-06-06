package com.example.daggersavecomponent

import android.app.Application

class ApplicationProvider : Application() {

    override fun onCreate() {
        super.onCreate()
        applicationProviderComponent = DaggerApplicationProviderComponent.factory().create()
    }

    companion object {
        val hashMap = HashMap<Int, AccountsOpeningComponent?>()

        private lateinit var applicationProviderComponent: ApplicationProviderComponent

        fun applicationProviderComponent(): ApplicationProviderComponent {
            return applicationProviderComponent
        }
    }
}
package com.example.daggersavecomponent

import dagger.Component

@Component
interface ApplicationProviderComponent {
    @Component.Factory
    interface Factory {
        fun create(): ApplicationProviderComponent
    }
}
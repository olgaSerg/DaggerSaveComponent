package com.example.daggersavecomponent

import dagger.Component

@Component
interface AccountsOpeningComponent {

    companion object {

        private var accountsOpeningComponent: AccountsOpeningComponent? = null

        fun init(applicationProviderComponent: ApplicationProviderComponent): AccountsOpeningComponent? {
            return accountsOpeningComponent
                ?: DaggerAccountsOpeningComponent
                .builder()
                .build()
                .also { accountsOpeningComponent = it }
        }

        fun getAccountsComponent(): AccountsOpeningComponent? {
            return accountsOpeningComponent
        }

        fun clear() {
            accountsOpeningComponent = null
        }
    }
}
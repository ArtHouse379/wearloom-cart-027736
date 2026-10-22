package anarimmagineinternationaluk.apparel.wearloomcart.di

import anarimmagineinternationaluk.apparel.wearloomcart.data.datastore.OnboardingDataStoreManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { OnboardingDataStoreManager(androidContext()) }
}
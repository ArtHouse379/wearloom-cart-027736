package anarimmagineinternationaluk.apparel.wearloomcart.di

import anarimmagineinternationaluk.apparel.wearloomcart.data.repository.CartRepository
import anarimmagineinternationaluk.apparel.wearloomcart.data.repository.OnboardingRepository
import anarimmagineinternationaluk.apparel.wearloomcart.data.repository.OrderRepository
import anarimmagineinternationaluk.apparel.wearloomcart.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        OnboardingRepository(
            onboardingDataStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}
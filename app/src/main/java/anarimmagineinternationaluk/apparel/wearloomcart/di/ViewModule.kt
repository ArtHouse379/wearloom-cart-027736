package anarimmagineinternationaluk.apparel.wearloomcart.di

import anarimmagineinternationaluk.apparel.wearloomcart.ui.viewmodel.AppViewModel
import anarimmagineinternationaluk.apparel.wearloomcart.ui.viewmodel.CartViewModel
import anarimmagineinternationaluk.apparel.wearloomcart.ui.viewmodel.CheckoutViewModel
import anarimmagineinternationaluk.apparel.wearloomcart.ui.viewmodel.OnboardingViewModel
import anarimmagineinternationaluk.apparel.wearloomcart.ui.viewmodel.OrderViewModel
import anarimmagineinternationaluk.apparel.wearloomcart.ui.viewmodel.ProductDetailsViewModel
import anarimmagineinternationaluk.apparel.wearloomcart.ui.viewmodel.ProductViewModel
import anarimmagineinternationaluk.apparel.wearloomcart.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}
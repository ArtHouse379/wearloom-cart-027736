package anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.cart.ZGPNCartScreen
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.checkout.ZGPNCheckoutScreen
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.home.ZGPNHomeScreen
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.onboarding.ZGPNOnboardingScreen
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.order.ZGPNOrdersScreen
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.productdetails.ZGPNProductDetailsScreen
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.settings.ZGPNSettingsScreen
import anarimmagineinternationaluk.apparel.wearloomcart.ui.composable.screen.splash.ZGPNSplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            ZGPNSplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            ZGPNOnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavRoute.Home) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Home> {
            ZGPNHomeScreen(
                onNavigateToProductDetails = { id: Int ->
                    navController.navigate(
                        route = NavRoute.ProductDetails(id = id)
                    )
                }
            )
        }

        composable<NavRoute.ProductDetails> { backStackEntry ->
            val productDetails: NavRoute.ProductDetails = backStackEntry.toRoute()
            ZGPNProductDetailsScreen(
                productId = productDetails.id,
            )
        }

        composable<NavRoute.Cart> {
            ZGPNCartScreen(
                onNavigateToCheckoutScreen = {
                    navController.navigate(NavRoute.Checkout)
                }
            )
        }

        composable<NavRoute.Checkout> {
            ZGPNCheckoutScreen(
                onNavigateToOrdersScreen = {
                    navController.navigate(NavRoute.Orders) {
                        popUpTo(NavRoute.Home) { inclusive = false }
                    }
                }
            )
        }

        composable<NavRoute.Orders> {
            ZGPNOrdersScreen()
        }

        composable<NavRoute.Settings> {
            ZGPNSettingsScreen()
        }
    }
}
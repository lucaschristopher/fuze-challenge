package com.example.fuzechallenge.presentation.commons.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.example.fuzechallenge.presentation.commons.navigation.actions.onNavigateToHome
import com.example.fuzechallenge.presentation.commons.navigation.routes.Routes
import com.example.fuzechallenge.presentation.splash.SplashScreen

internal fun NavGraphBuilder.splashScreen(
    navController: NavController
) {
    composable(route = Routes.Splash.route) {
        SplashScreen {
            navController.onNavigateToHome(
                navOptions {
                    this.popUpTo(Routes.Home.route) {
                        inclusive = true
                        saveState = true
                    }
                }
            )
        }
    }
}

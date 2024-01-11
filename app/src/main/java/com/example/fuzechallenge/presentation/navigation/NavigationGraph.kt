package com.example.fuzechallenge.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fuzechallenge.presentation.model.MatchUIModel
import com.example.fuzechallenge.presentation.navigation.Actions.Companion.ARG_MATCH
import com.example.fuzechallenge.presentation.ui.screen.detail.DetailScreen
import com.example.fuzechallenge.presentation.ui.screen.home.HomeScreen
import com.example.fuzechallenge.presentation.ui.screen.splash.SplashScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    val actions = remember(navController) { Actions(navController) }

    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route
    ) {
        composable(route = Routes.Splash.route) {
            SplashScreen(
                goToHome = actions.goToHome
            )
        }
        composable(route = Routes.Home.route) {
            HomeScreen(
                openMatchDetail = actions.openMatchDetail
            )
        }
        composable(route = Routes.Detail.route) {
            val match = navController.previousBackStackEntry
                ?.savedStateHandle?.get<MatchUIModel>(ARG_MATCH)

            DetailScreen(
                navigateBack = actions.navigateBack,
                match = match
            )
        }
    }
}

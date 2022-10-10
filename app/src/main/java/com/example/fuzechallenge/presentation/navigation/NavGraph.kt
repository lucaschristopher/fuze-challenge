package com.example.fuzechallenge.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fuzechallenge.core.constants.ARG_MATCH
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.ui.fragments.detail.DetailFragment
import com.example.fuzechallenge.presentation.ui.fragments.home.HomeFragment
import com.example.fuzechallenge.presentation.ui.fragments.splash.SplashFragment

@Composable
fun NavGraph(navController: NavHostController) {
    val actions = remember(navController) { Actions(navController) }

    NavHost(
        navController = navController,
        startDestination = Route.Splash.route
    ) {
        composable(route = Route.Splash.route) {
            SplashFragment(
                goToHome = actions.goToHome
            )
        }
        composable(route = Route.Home.route) {
            HomeFragment(
                openMatchDetail = actions.openMatchDetail
            )
        }
        composable(route = Route.Detail.route) {
            val match = navController.previousBackStackEntry
                ?.savedStateHandle?.get<MatchUiModel>(ARG_MATCH)

            DetailFragment(
                navigateBack = actions.navigateBack,
                match = match
            )
        }
    }
}
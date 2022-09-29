package com.example.fuzechallenge.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fuzechallenge.presentation.ui.fragments.home.HomeFragment

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Route.Home.route
    ) {
        composable(route = Route.Home.route) {
            HomeFragment(
                onClickToDetailScreen = { matchId ->
                    navHostController.navigate(
                        Route.Detail.createRoute(matchId)
                    )
                }
            )
        }
    }
}
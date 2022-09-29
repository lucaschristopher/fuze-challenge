package com.example.fuzechallenge.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fuzechallenge.core.constants.ARG_MATCH
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.ui.fragments.detail.DetailFragment
import com.example.fuzechallenge.presentation.ui.fragments.home.HomeFragment

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = Route.Home.route
    ) {
        composable(route = Route.Home.route) {
            HomeFragment(navController = navController)
        }
        composable(Route.Detail.route) {
            val result = navController.previousBackStackEntry
                ?.savedStateHandle?.get<MatchUiModel>(ARG_MATCH)

            DetailFragment(
                navController = navController,
                match = result
            )
        }
    }
}
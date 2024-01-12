package com.example.fuzechallenge.presentation.commons.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.fuzechallenge.presentation.commons.navigation.routes.Routes

@Composable
internal fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {

        listScreen(navController = navController)

        detailScreen(navController = navController)
    }
}

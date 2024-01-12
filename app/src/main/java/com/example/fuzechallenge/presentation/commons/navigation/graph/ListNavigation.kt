package com.example.fuzechallenge.presentation.commons.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.fuzechallenge.presentation.commons.navigation.actions.onNavigateToMatchDetails
import com.example.fuzechallenge.presentation.commons.navigation.routes.Routes
import com.example.fuzechallenge.presentation.list.ui.screen.MatchListScreen

internal fun NavGraphBuilder.listScreen(
    navController: NavController
) {
    composable(route = Routes.Home.route) {
        MatchListScreen { match ->
            navController.onNavigateToMatchDetails(match)
        }
    }
}
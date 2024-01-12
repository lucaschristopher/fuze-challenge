package com.example.fuzechallenge.presentation.commons.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.fuzechallenge.commons.constants.Constants.EMPTY_STRING
import com.example.fuzechallenge.presentation.commons.model.MatchArgs
import com.example.fuzechallenge.presentation.commons.navigation.actions.onNavigateBack
import com.example.fuzechallenge.presentation.commons.navigation.routes.Routes
import com.example.fuzechallenge.presentation.commons.utils.extensions.onlyNumbers
import com.example.fuzechallenge.presentation.detail.ui.screen.MatchDetailScreen

internal const val MATCH_ID = "matchId"
internal const val LEAGUE_NAME = "leagueName"
internal const val SERIE_NAME = "serieName"
internal fun NavGraphBuilder.detailScreen(
    navController: NavController
) {
    composable(
        route = Routes.Detail.route,
        arguments = listOf(
            navArgument(MATCH_ID) {
                type = NavType.StringType
            },
            navArgument(LEAGUE_NAME) {
                type = NavType.StringType
            },
            navArgument(SERIE_NAME) {
                type = NavType.StringType
            }
        )
    ) { backStackEntry ->
        val matchId = backStackEntry.arguments?.getString(MATCH_ID)?.onlyNumbers() ?: EMPTY_STRING
        val leagueName =
            backStackEntry.arguments?.getString(LEAGUE_NAME)?.onlyNumbers() ?: EMPTY_STRING
        val serieName =
            backStackEntry.arguments?.getString(SERIE_NAME)?.onlyNumbers() ?: EMPTY_STRING
        val matchArgs = MatchArgs(matchId, leagueName, serieName)

        MatchDetailScreen(
            matchArgs = matchArgs,
            onNavigateBack = {
                navController.onNavigateBack()
            },
        )
    }
}

package com.example.fuzechallenge.presentation.commons.navigation.routes

import com.example.fuzechallenge.presentation.commons.navigation.graph.LEAGUE_NAME
import com.example.fuzechallenge.presentation.commons.navigation.graph.MATCH_ID
import com.example.fuzechallenge.presentation.commons.navigation.graph.SERIE_NAME

internal sealed class Routes(val route: String) {
    object Splash : Routes(SPLASH_SCREEN)
    object Home : Routes(HOME_SCREEN)
    object Detail : Routes(
        route = "$DETAIL_SCREEN?$MATCH_ID={$MATCH_ID}" +
                "&$LEAGUE_NAME={$LEAGUE_NAME}" +
                "&$SERIE_NAME={$SERIE_NAME}"
    ) {
        fun createRoute(
            matchId: String,
            leagueName: String,
            serieName: String
        ) = "$DETAIL_SCREEN?$MATCH_ID={$matchId}" +
                "&$LEAGUE_NAME={$leagueName}" +
                "&$SERIE_NAME={$serieName}"
    }

    private companion object {
        const val SPLASH_SCREEN = "splash"
        const val HOME_SCREEN = "home"
        const val DETAIL_SCREEN = "detail"
    }
}

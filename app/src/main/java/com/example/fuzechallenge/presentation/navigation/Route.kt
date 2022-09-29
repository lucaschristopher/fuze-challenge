package com.example.fuzechallenge.presentation.navigation

import com.example.fuzechallenge.core.constants.DETAIL_ARG_MATCH_ID
import com.example.fuzechallenge.core.constants.DETAIL_SCREEN
import com.example.fuzechallenge.core.constants.HOME_SCREEN

sealed class Route(val route: String) {
    object Home : Route(HOME_SCREEN)
    object Detail : Route("$DETAIL_SCREEN/{$DETAIL_ARG_MATCH_ID}") {
        fun createRoute(matchId: Int) = "$DETAIL_SCREEN/$matchId"
    }
}

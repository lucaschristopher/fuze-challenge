package com.example.fuzechallenge.presentation.navigation

import com.example.fuzechallenge.core.constants.DETAIL_SCREEN
import com.example.fuzechallenge.core.constants.HOME_SCREEN
import com.example.fuzechallenge.core.constants.SPLASH_SCREEN

sealed class Route(val route: String) {
    object Splash : Route(SPLASH_SCREEN)
    object Home : Route(HOME_SCREEN)
    object Detail : Route(DETAIL_SCREEN)
}

package com.example.fuzechallenge.presentation.navigation

sealed class Routes(val route: String) {
    object Splash : Routes(SPLASH_SCREEN)
    object Home : Routes(HOME_SCREEN)
    object Detail : Routes(DETAIL_SCREEN)

    private companion object {
        const val SPLASH_SCREEN = "splash"
        const val HOME_SCREEN = "home"
        const val DETAIL_SCREEN = "detail"
    }
}

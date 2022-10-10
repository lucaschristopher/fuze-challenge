package com.example.fuzechallenge.presentation.navigation

import androidx.navigation.NavHostController
import com.example.fuzechallenge.core.constants.ARG_MATCH
import com.example.fuzechallenge.presentation.model.MatchUiModel

class Actions(navHostController: NavHostController) {

    val navigateBack: () -> Unit = {
        navHostController.navigateUp()
    }

    val goToHome: () -> Unit = {
        navHostController.navigate(Route.Home.route) {
            navHostController.popBackStack()
        }
    }

    val openMatchDetail: (MatchUiModel) -> Unit = { match ->
        navHostController.currentBackStackEntry?.savedStateHandle?.set(ARG_MATCH, match)
        navHostController.navigate(Route.Detail.route)
    }
}
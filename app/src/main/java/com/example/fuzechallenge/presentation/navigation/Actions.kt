package com.example.fuzechallenge.presentation.navigation

import androidx.navigation.NavHostController
import com.example.fuzechallenge.presentation.model.MatchUIModel

class Actions(navHostController: NavHostController) {

    val navigateBack: () -> Unit = {
        navHostController.navigateUp()
    }

    val goToHome: () -> Unit = {
        navHostController.navigate(Routes.Home.route) {
            navHostController.popBackStack()
        }
    }

    val openMatchDetail: (MatchUIModel) -> Unit = { match ->
        navHostController.currentBackStackEntry?.savedStateHandle?.set(ARG_MATCH, match)
        navHostController.navigate(Routes.Detail.route)
    }

    companion object {
        const val ARG_MATCH = "match"
    }
}

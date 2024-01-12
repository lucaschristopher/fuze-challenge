package com.example.fuzechallenge.presentation.commons.navigation.actions

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.fuzechallenge.presentation.commons.navigation.routes.Routes
import com.example.fuzechallenge.presentation.list.model.MatchUIModel

internal fun NavController.onNavigateBack() {
    this.navigateUp()
}

internal fun NavController.onNavigateToHome(navOptions: NavOptions? = null) {
    this.navigate(Routes.Home.route, navOptions)
}

internal fun NavController.onNavigateToMatchDetails(matchUIModel: MatchUIModel) {
    val route = Routes.Detail.createRoute(
        matchId = matchUIModel.id.toString(),
        leagueName = matchUIModel.league.name,
        serieName = matchUIModel.serie.name
    )
    this.navigate(route)
}

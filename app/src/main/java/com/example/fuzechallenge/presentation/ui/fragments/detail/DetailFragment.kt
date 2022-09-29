package com.example.fuzechallenge.presentation.ui.fragments.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.fuzechallenge.R
import com.example.fuzechallenge.core.constants.FULL_OPPONENTS_QUANTITY
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.state.ViewState
import com.example.fuzechallenge.presentation.theme.*
import com.example.fuzechallenge.presentation.ui.components.core.LoadingComponent
import com.example.fuzechallenge.presentation.ui.components.detail.DetailTopBar
import com.example.fuzechallenge.presentation.ui.components.detail.MatchTime
import com.example.fuzechallenge.presentation.ui.components.detail.TeamList
import com.example.fuzechallenge.presentation.ui.components.home.RowTeamImages
import com.example.fuzechallenge.presentation.viewmodel.DetailViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailFragment(
    modifier: Modifier = Modifier,
    navController: NavController,
    match: MatchUiModel?
) {
    val viewModel = getViewModel<DetailViewModel>()

    fun setupData() {
        match?.let {
            viewModel.hasOpponents = match.opponents.isNotEmpty()
            viewModel.hasFullOpponents = match.opponents.size == FULL_OPPONENTS_QUANTITY
        }
    }

    fun validateCalls() {
        if (viewModel.hasOpponents && viewModel.hasFullOpponents) {
            match?.opponents?.first()?.opponent?.id?.let { viewModel.getFirstGangDetail(it.toString()) }
            match?.opponents?.last()?.opponent?.id?.let { viewModel.getSecondGangDetail(it.toString()) }
        } else if (viewModel.hasOpponents && !viewModel.hasFullOpponents) {
            match?.opponents?.first()?.opponent?.id?.let { viewModel.getFirstGangDetail(it.toString()) }
        }
    }

    fun launch() {
        setupData()
        validateCalls()
    }

    launch()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        backgroundColor = BlackFuze,
        topBar = {
            DetailTopBar(
                navController = navController,
                serieName = match?.serie?.name ?: stringResource(id = R.string.default_serie_label),
                leagueName = match?.league?.name
                    ?: stringResource(id = R.string.default_league_label)
            )
        },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = dp4, bottom = dp16),
        ) {
            match?.let { it ->
                RowTeamImages(match = it)
                MatchTime(it)
                if (viewModel.hasFullOpponents) {
                    Row {
                        BuildFirstTeamPlayerList(viewModel)
                        BuildSecondTeamPlayerList(viewModel)
                    }
                } else if (viewModel.hasOpponents && !viewModel.hasFullOpponents) {
                    BuildFirstTeamPlayerList(viewModel)
                } else {
                    Text(
                        modifier = Modifier.padding(vertical = dp24),
                        text = stringResource(id = R.string.no_teams_label),
                        fontSize = sp14,
                        color = Color.White,
                    )
                }
            }
        }
    }
}

@Composable
private fun BuildFirstTeamPlayerList(viewModel: DetailViewModel) {
    when (val state = viewModel.firstGangDetail.collectAsState().value) {
        is ViewState.Loading -> LoadingComponent()
        is ViewState.Success -> TeamList(state.data)
        is ViewState.Error -> Unit
        else -> Unit
    }
}

@Composable
private fun BuildSecondTeamPlayerList(viewModel: DetailViewModel) {
    when (val state = viewModel.secondGangDetail.collectAsState().value) {
        is ViewState.Loading -> LoadingComponent()
        is ViewState.Success -> TeamList(state.data)
        is ViewState.Error -> Unit
        else -> Unit
    }
}

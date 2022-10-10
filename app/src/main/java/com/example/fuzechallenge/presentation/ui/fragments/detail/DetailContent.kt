package com.example.fuzechallenge.presentation.ui.fragments.detail

import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.state.ViewState
import com.example.fuzechallenge.presentation.theme.dp16
import com.example.fuzechallenge.presentation.theme.dp4
import com.example.fuzechallenge.presentation.ui.components.core.DefaultErrorMessage
import com.example.fuzechallenge.presentation.ui.components.core.LoadingComponent
import com.example.fuzechallenge.presentation.ui.components.detail.FirstTeamList
import com.example.fuzechallenge.presentation.ui.components.detail.MatchTime
import com.example.fuzechallenge.presentation.ui.components.detail.SecondTeamList
import com.example.fuzechallenge.presentation.ui.components.home.RowTeamImages
import com.example.fuzechallenge.presentation.ui.util.LockScreenOrientation
import com.example.fuzechallenge.presentation.viewmodel.DetailViewModel

@Composable
fun DetailContent(
    match: MatchUiModel?,
    viewModel: DetailViewModel
) {
    LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dp4, bottom = dp16),
    ) {
        match?.let { it ->
            RowTeamImages(match = it)
            MatchTime(it)
            when (val state = viewModel.teamsInfo.collectAsState().value) {
                is ViewState.Loading -> LoadingComponent()
                is ViewState.Error -> DefaultErrorMessage(state.throwable)
                is ViewState.Success -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        FirstTeamList(state.data.first())
                        SecondTeamList(state.data.last())
                    }
                }
                else -> Unit
            }
        }
    }
}
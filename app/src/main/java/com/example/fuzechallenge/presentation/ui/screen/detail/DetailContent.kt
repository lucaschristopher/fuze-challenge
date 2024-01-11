package com.example.fuzechallenge.presentation.ui.screen.detail

import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.fuzechallenge.presentation.model.CSGoViewModelState
import com.example.fuzechallenge.presentation.model.MatchUIModel
import com.example.fuzechallenge.presentation.ui.components.DefaultErrorMessage
import com.example.fuzechallenge.presentation.ui.components.FirstTeamList
import com.example.fuzechallenge.presentation.ui.components.LoadingComponent
import com.example.fuzechallenge.presentation.ui.components.MatchTime
import com.example.fuzechallenge.presentation.ui.components.RowTeamImages
import com.example.fuzechallenge.presentation.ui.components.SecondTeamList
import com.example.fuzechallenge.presentation.ui.theme.dp16
import com.example.fuzechallenge.presentation.ui.theme.dp4
import com.example.fuzechallenge.presentation.ui.utils.extensions.LockScreenOrientation
import com.example.fuzechallenge.presentation.viewmodel.DetailViewModel

@Composable
internal fun DetailContent(
    modifier: Modifier = Modifier,
    match: MatchUIModel?,
    viewModel: DetailViewModel
) {
    val context = LocalContext.current
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(top = dp4, bottom = dp16),
    ) {
        match?.let { it ->
            RowTeamImages(match = it)
            MatchTime(it)
            when (val state = viewModel.teamsInfo.collectAsState().value) {
                is CSGoViewModelState.Loading -> LoadingComponent()
                is CSGoViewModelState.Error -> DefaultErrorMessage(errorMessage = state.errorMessage)
                is CSGoViewModelState.Success -> {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        FirstTeamList(state.gangs.first())
                        SecondTeamList(state.gangs.last())
                    }
                }

                else -> Unit
            }
        }
    }
}
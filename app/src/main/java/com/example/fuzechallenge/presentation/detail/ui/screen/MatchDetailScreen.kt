package com.example.fuzechallenge.presentation.detail.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.commons.model.CSGoViewModelState
import com.example.fuzechallenge.presentation.commons.model.MatchArgs
import com.example.fuzechallenge.presentation.commons.ui.components.AppTopBar
import com.example.fuzechallenge.presentation.commons.ui.components.DefaultErrorMessage
import com.example.fuzechallenge.presentation.commons.ui.components.LoadingComponent
import com.example.fuzechallenge.presentation.commons.ui.theme.BlackFuze
import com.example.fuzechallenge.presentation.detail.viewmodel.MatchDetailsViewModel

@Composable
internal fun MatchDetailScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    matchArgs: MatchArgs
) {
    val viewModel: MatchDetailsViewModel = hiltViewModel()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = BlackFuze,
        topBar = {
            val serieName =
                matchArgs.serieName.ifEmpty {
                    stringResource(id = R.string.default_serie_label)
                }
            val leagueName = matchArgs.leagueName.ifEmpty {
                stringResource(id = R.string.default_league_label)
            }

            AppTopBar(
                navigateBack = onNavigateBack,
                showBackButton = true,
                title = {
                    Text(
                        text = "$serieName | $leagueName",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            )
        },
        content = { padding ->
            when (val state = viewModel.state.collectAsStateWithLifecycle().value) {
                is CSGoViewModelState.Loading -> LoadingComponent()
                is CSGoViewModelState.Error -> DefaultErrorMessage(errorMessage = state.errorMessage)
                is CSGoViewModelState.Success -> {
                    MatchDetailContent(
                        modifier = modifier.padding(padding),
                        match = state.match
                    )
                }

                else -> Unit
            }
        }
    )
}

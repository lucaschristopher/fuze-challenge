package com.example.fuzechallenge.presentation.ui.screen.detail

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
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.model.MatchUIModel
import com.example.fuzechallenge.presentation.ui.components.AppTopBar
import com.example.fuzechallenge.presentation.ui.theme.BlackFuze
import com.example.fuzechallenge.presentation.viewmodel.DetailViewModel

@Composable
internal fun DetailScreen(
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit,
    match: MatchUIModel?
) {
    val viewModel: DetailViewModel = hiltViewModel()

    fun getGangs() = viewModel.getTeamsInfo(match?.opponents)

    getGangs()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = BlackFuze,
        topBar = {
            val serieName = match?.serie?.name ?: stringResource(id = R.string.default_serie_label)
            val leagueName = match?.league?.name
                ?: stringResource(id = R.string.default_league_label)

            AppTopBar(
                navigateBack = navigateBack,
                showBackButton = true,
                title = {
                    Text(
                        text = "$serieName / $leagueName",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            )
        },
        content = { padding ->
            DetailContent(
                modifier = modifier.padding(padding),
                match = match,
                viewModel = viewModel
            )
        }
    )
}

package com.example.fuzechallenge.presentation.ui.fragments.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.theme.BlackFuze
import com.example.fuzechallenge.presentation.ui.components.core.AppTopBar
import com.example.fuzechallenge.presentation.viewmodel.DetailViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailFragment(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    match: MatchUiModel?
) {
    val viewModel = getViewModel<DetailViewModel>()
    fun getGangs() = viewModel.getTeamsInfo(match?.opponents)

    getGangs()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        backgroundColor = BlackFuze,
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
                        style = MaterialTheme.typography.subtitle1
                    )
                }
            )
        },
        content = {
            DetailContent(
                match = match,
                viewModel = viewModel
            )
        }
    )
}

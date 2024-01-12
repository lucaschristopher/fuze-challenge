package com.example.fuzechallenge.presentation.list.ui.screen

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
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.commons.ui.components.AppTopBar
import com.example.fuzechallenge.presentation.commons.ui.theme.BlackFuze
import com.example.fuzechallenge.presentation.list.model.MatchUIModel
import com.example.fuzechallenge.presentation.list.viewmodel.MatchListViewModel

@Composable
internal fun MatchListScreen(
    modifier: Modifier = Modifier,
    onNavigateToMatchDetails: (MatchUIModel) -> Unit
) {
    val viewModel: MatchListViewModel = hiltViewModel()
    val matches = viewModel.state.collectAsLazyPagingItems()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = BlackFuze,
        topBar = {
            AppTopBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.main_title),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            )
        },
        content = { padding ->
            MatchListContent(
                modifier = modifier.padding(padding),
                matches = matches,
                openMatchDetail = onNavigateToMatchDetails
            )
        }
    )
}
package com.example.fuzechallenge.presentation.ui.screen.home

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
import com.example.fuzechallenge.presentation.model.MatchUIModel
import com.example.fuzechallenge.presentation.ui.components.AppTopBar
import com.example.fuzechallenge.presentation.ui.theme.BlackFuze
import com.example.fuzechallenge.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    openMatchDetail: (MatchUIModel) -> Unit
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val matches = viewModel.matchList().collectAsLazyPagingItems()

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
            HomeContent(
                openMatchDetail = openMatchDetail,
                matches = matches,
                modifier = modifier.padding(padding)
            )
        }
    )
}
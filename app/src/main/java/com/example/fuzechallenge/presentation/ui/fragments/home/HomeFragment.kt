package com.example.fuzechallenge.presentation.ui.fragments.home

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
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.theme.BlackFuze
import com.example.fuzechallenge.presentation.ui.components.core.AppTopBar
import com.example.fuzechallenge.presentation.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier,
    openMatchDetail: (MatchUiModel) -> Unit
) {
    val viewModel = getViewModel<HomeViewModel>()
    val matches = viewModel.matchList().collectAsLazyPagingItems()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        backgroundColor = BlackFuze,
        topBar = {
            AppTopBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.main_title),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h4
                    )
                }
            )
        },
        content = {
            HomeContent(
                openMatchDetail = openMatchDetail,
                matches = matches,
                modifier = modifier
            )
        }
    )
}

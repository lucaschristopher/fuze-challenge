package com.example.fuzechallenge.presentation.ui.fragments.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.fuzechallenge.presentation.theme.BlackFuze
import com.example.fuzechallenge.presentation.theme.FuzeChallengeTheme
import com.example.fuzechallenge.presentation.ui.components.home.HomeTopBar
import com.example.fuzechallenge.presentation.viewmodel.AppViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier,
    onClickToDetailScreen: (Int) -> Unit = {}
) {
    val viewModel = getViewModel<AppViewModel>()
    val matches = viewModel.matchList().collectAsLazyPagingItems()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        backgroundColor = BlackFuze,
        topBar = { HomeTopBar() },
        content = {
            HomeScreen(
                onClickToDetailScreen = onClickToDetailScreen,
                matches = matches
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeFragmentPreview() {
    FuzeChallengeTheme {
        HomeFragment()
    }
}
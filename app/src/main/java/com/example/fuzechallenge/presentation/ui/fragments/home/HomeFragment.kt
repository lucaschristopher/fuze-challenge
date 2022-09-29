package com.example.fuzechallenge.presentation.ui.fragments.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.fuzechallenge.presentation.theme.BlackFuze
import com.example.fuzechallenge.presentation.ui.components.home.HomeTopBar
import com.example.fuzechallenge.presentation.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val viewModel = getViewModel<HomeViewModel>()
    val matches = viewModel.matchList().collectAsLazyPagingItems()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        backgroundColor = BlackFuze,
        topBar = { HomeTopBar() },
        content = {
            HomeScreen(
                navController = navController,
                matches = matches
            )
        }
    )
}

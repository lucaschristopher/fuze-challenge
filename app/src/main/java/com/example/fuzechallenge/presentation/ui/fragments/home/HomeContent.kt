package com.example.fuzechallenge.presentation.ui.fragments.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.theme.dp16
import com.example.fuzechallenge.presentation.ui.components.core.ErrorDialog
import com.example.fuzechallenge.presentation.ui.components.core.LoadingComponent
import com.example.fuzechallenge.presentation.ui.components.core.LoadingItem
import com.example.fuzechallenge.presentation.ui.components.home.MatchCard
import com.example.fuzechallenge.presentation.ui.util.showToast

@Composable
fun HomeContent(
    openMatchDetail: (MatchUiModel) -> Unit,
    matches: LazyPagingItems<MatchUiModel>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(all = dp16),
    ) {
        items(items = matches) { item ->
            item?.let {
                MatchCard(
                    match = it,
                    openMatchDetail = openMatchDetail
                )
            }
        }

        when (matches.loadState.append) {
            is LoadState.NotLoading -> Unit
            LoadState.Loading -> {
                item { LoadingItem() }
            }
            is LoadState.Error -> showToast(context)
        }
    }

    matches.apply {
        when (loadState.refresh) {
            is LoadState.Loading -> LoadingComponent()
            is LoadState.Error -> ErrorDialog(
                onClick = { retry() }
            )
            else -> Unit
        }
    }
}

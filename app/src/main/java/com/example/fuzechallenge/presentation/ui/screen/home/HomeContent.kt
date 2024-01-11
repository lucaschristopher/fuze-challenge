package com.example.fuzechallenge.presentation.ui.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.fuzechallenge.presentation.model.MatchUIModel
import com.example.fuzechallenge.presentation.ui.components.ErrorDialog
import com.example.fuzechallenge.presentation.ui.components.LoadingComponent
import com.example.fuzechallenge.presentation.ui.components.LoadingItem
import com.example.fuzechallenge.presentation.ui.components.MatchCard
import com.example.fuzechallenge.presentation.ui.theme.dp16
import com.example.fuzechallenge.presentation.ui.utils.extensions.showErrorToast

@Composable
fun HomeContent(
    openMatchDetail: (MatchUIModel) -> Unit,
    matches: LazyPagingItems<MatchUIModel>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(all = dp16),
    ) {
        items(count = matches.itemCount) { index ->
            val item = matches[index]
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

            is LoadState.Error -> context.showErrorToast()
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
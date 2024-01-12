package com.example.fuzechallenge.presentation.list.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.fuzechallenge.presentation.commons.ui.components.ErrorDialog
import com.example.fuzechallenge.presentation.commons.ui.components.LoadingComponent
import com.example.fuzechallenge.presentation.commons.ui.components.LoadingItem
import com.example.fuzechallenge.presentation.commons.ui.theme.dp16
import com.example.fuzechallenge.presentation.commons.utils.extensions.showErrorToast
import com.example.fuzechallenge.presentation.list.model.MatchUIModel
import com.example.fuzechallenge.presentation.list.ui.components.MatchCard

@Composable
internal fun MatchListContent(
    modifier: Modifier = Modifier,
    openMatchDetail: (MatchUIModel) -> Unit,
    matches: LazyPagingItems<MatchUIModel>
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

        when (matches.loadState.append) { // FIXME
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
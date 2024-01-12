package com.example.fuzechallenge.presentation.list.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.fuzechallenge.presentation.commons.ui.components.ErrorDialog
import com.example.fuzechallenge.presentation.commons.ui.components.LoadingComponent
import com.example.fuzechallenge.presentation.commons.ui.components.LoadingItem
import com.example.fuzechallenge.presentation.commons.ui.theme.dp16
import com.example.fuzechallenge.presentation.commons.ui.theme.dp4
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

    /**
     * LoadType is an Enum and it has 3 type
     *
     * APPEND : used to load at the end of a PagingData
     * PREPEND : used load at the start of a PagingData
     * REFRESH : used to refresh or initial load of a PagingData
     */

    LaunchedEffect(matches.loadState) {
        if (matches.loadState.append is LoadState.Error) {
            context.showErrorToast()
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = dp16,
                end = dp16,
                bottom = dp16,
                top = dp4
            ),
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

        item {
            if (matches.loadState.append is LoadState.Loading) {
                LoadingItem()
            }
        }
    }

    when (matches.loadState.refresh) {
        is LoadState.Loading -> LoadingComponent()
        is LoadState.Error -> ErrorDialog(
            modifier = modifier,
            onClick = { matches.retry() }
        )

        else -> Unit
    }
}
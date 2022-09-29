package com.example.fuzechallenge.presentation.ui.fragments.home

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.theme.dp16
import com.example.fuzechallenge.presentation.ui.components.core.ErrorDialog
import com.example.fuzechallenge.presentation.ui.components.core.LoadingComponent
import com.example.fuzechallenge.presentation.ui.components.core.LoadingItem
import com.example.fuzechallenge.presentation.ui.components.home.MatchCard

@Composable
fun HomeScreen(
    navController: NavHostController,
    matches: LazyPagingItems<MatchUiModel>
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = dp16),
    ) {
        items(items = matches) { item ->
            item?.let {
                MatchCard(
                    match = it,
                    navController = navController
                )
            }
        }

        when (matches.loadState.append) {
            is LoadState.NotLoading -> Unit
            LoadState.Loading -> {
                item {
                    LoadingItem()
                }
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

fun showToast(context: Context) {
    Toast.makeText(context, R.string.error_toast_message, Toast.LENGTH_LONG).show()
}

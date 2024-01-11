package com.example.fuzechallenge.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.ui.theme.BlackFuze
import com.example.fuzechallenge.presentation.ui.theme.Gray
import com.example.fuzechallenge.presentation.ui.theme.dp16

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    showBackButton: Boolean = false,
    navigateBack: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier.padding(dp16),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BlackFuze,
            titleContentColor = Gray,
        ),
        title = { title() },
        navigationIcon = {
            if (showBackButton) {
                IconButton(onClick = { navigateBack.invoke() }) {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button_description)
                    )
                }
            } else Unit
        }
    )
}

package com.example.fuzechallenge.presentation.ui.components.core

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.example.fuzechallenge.R
import com.example.fuzechallenge.core.constants.APP_TOP_BAR_COMPONENT
import com.example.fuzechallenge.presentation.theme.BlackFuze
import com.example.fuzechallenge.presentation.theme.dp0
import com.example.fuzechallenge.presentation.theme.dp16

@Composable
fun AppTopBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    showBackButton: Boolean = false,
    navigateBack: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier
            .padding(dp16)
            .testTag(APP_TOP_BAR_COMPONENT),
        backgroundColor = BlackFuze,
        elevation = dp0,
        title = { title() },
        navigationIcon = if (showBackButton) {
            {
                IconButton(onClick = { navigateBack.invoke() }) {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button_description)
                    )
                }
            }
        } else {
            null
        }
    )
}

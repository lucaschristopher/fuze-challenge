package com.example.fuzechallenge.presentation.commons.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.fuzechallenge.presentation.commons.ui.theme.RedFuze
import com.example.fuzechallenge.presentation.commons.ui.theme.dp42
import com.example.fuzechallenge.presentation.commons.ui.theme.dp6
import com.example.fuzechallenge.presentation.commons.ui.theme.dp8

@Composable
internal fun LoadingItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = modifier
                .width(dp42)
                .height(dp42)
                .padding(dp8),
            color = RedFuze,
            strokeWidth = dp6
        )
    }
}

package com.example.fuzechallenge.presentation.ui.components.core

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.fuzechallenge.presentation.theme.RedFuze
import com.example.fuzechallenge.presentation.theme.dp42
import com.example.fuzechallenge.presentation.theme.dp6
import com.example.fuzechallenge.presentation.theme.dp8

@Composable
fun LoadingItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(dp42)
                .height(dp42)
                .padding(dp8),
            color = RedFuze,
            strokeWidth = dp6
        )
    }
}

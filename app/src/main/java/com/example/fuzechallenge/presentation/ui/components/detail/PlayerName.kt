package com.example.fuzechallenge.presentation.ui.components.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.fuzechallenge.core.constants.MAX_LINES
import com.example.fuzechallenge.presentation.theme.Gray
import com.example.fuzechallenge.presentation.theme.sp12

@Composable
fun PlayerName(playerName: String, modifier: Modifier = Modifier) {
    Text(
        text = playerName,
        fontSize = sp12,
        color = Gray,
        overflow = TextOverflow.Ellipsis,
        maxLines = MAX_LINES,
        textAlign = TextAlign.Center,
        modifier = modifier,
    )
}
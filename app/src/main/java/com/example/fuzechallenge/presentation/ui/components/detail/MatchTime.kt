package com.example.fuzechallenge.presentation.ui.components.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.fuzechallenge.core.constants.NO_TIME
import com.example.fuzechallenge.core.util.formatTime
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.theme.dp24
import com.example.fuzechallenge.presentation.theme.sp14

@Composable
fun MatchTime(it: MatchUiModel, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(vertical = dp24),
        text = formatTime(it.status, it.scheduledAt) ?: NO_TIME,
        fontSize = sp14,
        color = Color.White,
    )
}
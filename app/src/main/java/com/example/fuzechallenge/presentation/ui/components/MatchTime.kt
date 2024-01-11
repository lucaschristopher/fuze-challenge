package com.example.fuzechallenge.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.fuzechallenge.commons.constants.Constants
import com.example.fuzechallenge.presentation.model.MatchUIModel
import com.example.fuzechallenge.presentation.ui.theme.dp24
import com.example.fuzechallenge.presentation.ui.theme.sp14
import com.example.fuzechallenge.presentation.ui.utils.time.TimeUtils

@Composable
fun MatchTime(it: MatchUIModel, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(vertical = dp24),
        text = TimeUtils.formatTime(it.status, it.scheduledAt) ?: Constants.NO_TIME,
        fontSize = sp14,
        color = Color.White,
    )
}

package com.example.fuzechallenge.presentation.commons.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.fuzechallenge.presentation.commons.ui.theme.dp24
import com.example.fuzechallenge.presentation.commons.ui.theme.sp14
import com.example.fuzechallenge.presentation.commons.utils.time.TimeUtils
import com.example.fuzechallenge.presentation.list.model.MatchUIModel

@Composable
internal fun MatchTime(
    modifier: Modifier = Modifier,
    matchUIModel: MatchUIModel
) {
    Text(
        modifier = modifier.padding(vertical = dp24),
        text = TimeUtils.formatTime(matchUIModel.status, matchUIModel.scheduledAt),
        fontSize = sp14,
        color = Color.White,
    )
}

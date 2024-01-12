package com.example.fuzechallenge.presentation.list.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.fuzechallenge.commons.constants.Constants.NO_TIME
import com.example.fuzechallenge.presentation.commons.model.MatchStatus
import com.example.fuzechallenge.presentation.commons.ui.theme.Gray
import com.example.fuzechallenge.presentation.commons.ui.theme.RedFuze
import com.example.fuzechallenge.presentation.commons.ui.theme.dp10
import com.example.fuzechallenge.presentation.commons.ui.theme.dp16
import com.example.fuzechallenge.presentation.commons.ui.theme.dp24
import com.example.fuzechallenge.presentation.commons.ui.theme.sp10
import com.example.fuzechallenge.presentation.commons.utils.time.TimeUtils

@Composable
internal fun StatusBadge(modifier: Modifier = Modifier, matchStatus: String, scheduledAt: String) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(bottomStart = dp16))
            .background(if (matchStatus == MatchStatus.RUNNING.status) RedFuze else Gray)
            .wrapContentWidth()
            .padding(horizontal = dp10)
            .height(dp24),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = TimeUtils.formatTime(matchStatus, scheduledAt) ?: NO_TIME,
            fontSize = sp10,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

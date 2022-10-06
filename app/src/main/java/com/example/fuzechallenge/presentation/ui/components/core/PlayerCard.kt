package com.example.fuzechallenge.presentation.ui.components.core

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.fuzechallenge.presentation.model.detail.PlayerUiModel
import com.example.fuzechallenge.presentation.theme.*
import com.example.fuzechallenge.presentation.ui.components.detail.PlayerImage

@Composable
fun PlayerCard(
    player: PlayerUiModel,
    alignment: Alignment,
    body: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.width(dp179),
        contentAlignment = alignment
    ) {
        Card(
            backgroundColor = DeepPurple,
            elevation = dp4,
            shape = RoundedCornerShape(dp16),
            modifier = modifier
                .height(dp80)
                .fillMaxWidth()
                .padding(dp6),
            content = { body() }
        )
        PlayerImage(
            player = player,
            modifier = modifier
        )
    }
}
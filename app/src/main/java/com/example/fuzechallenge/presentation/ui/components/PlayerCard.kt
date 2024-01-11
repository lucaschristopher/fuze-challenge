package com.example.fuzechallenge.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.fuzechallenge.presentation.model.PlayerUIModel
import com.example.fuzechallenge.presentation.ui.theme.DeepPurple
import com.example.fuzechallenge.presentation.ui.theme.dp16
import com.example.fuzechallenge.presentation.ui.theme.dp179
import com.example.fuzechallenge.presentation.ui.theme.dp4
import com.example.fuzechallenge.presentation.ui.theme.dp6
import com.example.fuzechallenge.presentation.ui.theme.dp80

@Composable
fun PlayerCard(
    player: PlayerUIModel,
    alignment: Alignment,
    body: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.width(dp179),
        contentAlignment = alignment
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = DeepPurple
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = dp4
            ),
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

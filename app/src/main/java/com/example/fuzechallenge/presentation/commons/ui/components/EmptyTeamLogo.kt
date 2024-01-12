package com.example.fuzechallenge.presentation.commons.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import com.example.fuzechallenge.commons.constants.Constants.CANVA_DIVISOR
import com.example.fuzechallenge.presentation.commons.ui.theme.Gray

@Composable
internal fun EmptyTeamLogo(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawCircle(
            color = Gray,
            center = Offset(
                x = canvasWidth / CANVA_DIVISOR,
                y = canvasHeight / CANVA_DIVISOR
            ),
            radius = size.minDimension / CANVA_DIVISOR
        )
    }
}

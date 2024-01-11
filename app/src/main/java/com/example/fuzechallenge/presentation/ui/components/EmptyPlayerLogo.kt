package com.example.fuzechallenge.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.fuzechallenge.presentation.ui.theme.Gray
import com.example.fuzechallenge.presentation.ui.theme.dp10
import com.example.fuzechallenge.presentation.ui.theme.dp16
import com.example.fuzechallenge.presentation.ui.theme.dp60

@Composable
fun EmptyPlayerLogo(modifier: Modifier = Modifier) {
    Box(
        modifier
            .padding(horizontal = dp16)
            .clip(RoundedCornerShape(dp10))
            .background(color = Gray)
            .width(dp60)
            .height(dp60)
    )
}

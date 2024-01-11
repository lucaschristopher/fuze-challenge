package com.example.fuzechallenge.presentation.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.fuzechallenge.commons.constants.Constants.MAX_LINES
import com.example.fuzechallenge.presentation.ui.theme.sp16

@Composable
fun PlayerNickName(nickName: String, modifier: Modifier = Modifier) {
    Text(
        text = nickName,
        fontSize = sp16,
        color = Color.White,
        overflow = TextOverflow.Ellipsis,
        maxLines = MAX_LINES,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}
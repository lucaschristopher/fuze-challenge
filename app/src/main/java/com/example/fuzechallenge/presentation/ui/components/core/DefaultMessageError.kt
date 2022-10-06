package com.example.fuzechallenge.presentation.ui.components.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.fuzechallenge.core.constants.MATCH_MESSAGE_ERROR
import com.example.fuzechallenge.presentation.theme.sp14

@Composable
fun DefaultErrorMessage(throwable: Throwable, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = throwable.message ?: MATCH_MESSAGE_ERROR,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = sp14
        )
    }
}

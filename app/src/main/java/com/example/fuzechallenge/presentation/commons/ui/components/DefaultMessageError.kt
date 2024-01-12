package com.example.fuzechallenge.presentation.commons.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.fuzechallenge.commons.constants.Constants.MATCH_MESSAGE_ERROR
import com.example.fuzechallenge.presentation.commons.ui.theme.sp14

@Composable
internal fun DefaultErrorMessage(
    modifier: Modifier = Modifier,
    errorMessage: String? = null
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = errorMessage ?: MATCH_MESSAGE_ERROR,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = sp14
        )
    }
}

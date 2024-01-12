package com.example.fuzechallenge.presentation.commons.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.fuzechallenge.R
import com.example.fuzechallenge.commons.constants.Constants.MATCH_MESSAGE_ERROR
import com.example.fuzechallenge.presentation.commons.ui.theme.dp16
import com.example.fuzechallenge.presentation.commons.ui.theme.sp16

@Composable
internal fun DefaultErrorMessage(
    modifier: Modifier = Modifier,
    errorMessage: String? = null
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = dp16),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.error_message, errorMessage ?: MATCH_MESSAGE_ERROR),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = sp16
        )
    }
}

package com.example.fuzechallenge.presentation.ui.components.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.theme.BlackFuze
import com.example.fuzechallenge.presentation.theme.FuzeChallengeTheme
import com.example.fuzechallenge.presentation.theme.dp0
import com.example.fuzechallenge.presentation.theme.dp16

@Composable
fun HomeTopBar() {
    TopAppBar(
        modifier = Modifier.padding(dp16),
        backgroundColor = BlackFuze,
        title = {
            Text(
                text = stringResource(id = R.string.main_title),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h4
            )
        },
        elevation = dp0
    )
}

@Preview(showBackground = true)
@Composable
fun HomeTopBarPreview() {
    FuzeChallengeTheme {
        HomeTopBar()
    }
}
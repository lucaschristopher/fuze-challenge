package com.example.fuzechallenge.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.model.MatchUIModel
import com.example.fuzechallenge.presentation.ui.theme.dp10
import com.example.fuzechallenge.presentation.ui.theme.dp12
import com.example.fuzechallenge.presentation.ui.theme.dp16
import com.example.fuzechallenge.presentation.ui.theme.dp18
import com.example.fuzechallenge.presentation.ui.theme.sp10

@Composable
fun RowMatchInfo(match: MatchUIModel, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = dp16, end = dp16, bottom = dp12),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        LogoImage(
            imageUrl = match.league.imageUrl,
            sizeImage = dp18
        )
        Text(
            modifier = modifier.padding(start = dp10),
            text = stringResource(
                R.string.match_info,
                getValidLeagueName(match.league.name),
                getValidSerieName(match.serie.name)
            ), fontSize = sp10, color = Color.White
        )
    }
}

@Composable
private fun getValidLeagueName(leagueName: String?) =
    if (leagueName.isNullOrBlank()) stringResource(R.string.default_league_label) else leagueName


@Composable
private fun getValidSerieName(serieName: String?) =
    if (serieName.isNullOrBlank()) stringResource(R.string.default_serie_label) else serieName

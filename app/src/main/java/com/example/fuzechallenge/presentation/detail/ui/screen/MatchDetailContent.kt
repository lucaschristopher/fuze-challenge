package com.example.fuzechallenge.presentation.detail.ui.screen

import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.fuzechallenge.presentation.detail.ui.components.FirstTeamList
import com.example.fuzechallenge.presentation.commons.ui.components.MatchTime
import com.example.fuzechallenge.presentation.commons.ui.components.RowTeamImages
import com.example.fuzechallenge.presentation.detail.ui.components.SecondTeamList
import com.example.fuzechallenge.presentation.commons.ui.theme.dp16
import com.example.fuzechallenge.presentation.commons.ui.theme.dp4
import com.example.fuzechallenge.presentation.commons.utils.extensions.LockScreenOrientation
import com.example.fuzechallenge.presentation.list.model.MatchUIModel

@Composable
internal fun MatchDetailContent(
    modifier: Modifier = Modifier,
    match: MatchUIModel
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(top = dp4, bottom = dp16),
    ) {
        if (match.opponents.isNotEmpty()) {
            RowTeamImages(teams = match.opponents)
            MatchTime(matchUIModel = match)
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FirstTeamList(data = match.opponents.first())
                SecondTeamList(data = match.opponents.last())
            }
        }
    }
}
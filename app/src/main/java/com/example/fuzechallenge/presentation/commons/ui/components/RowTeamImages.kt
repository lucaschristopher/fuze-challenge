package com.example.fuzechallenge.presentation.commons.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.commons.ui.theme.Gray
import com.example.fuzechallenge.presentation.commons.ui.theme.dp16
import com.example.fuzechallenge.presentation.commons.ui.theme.dp40
import com.example.fuzechallenge.presentation.commons.ui.theme.sp12
import com.example.fuzechallenge.presentation.detail.ui.components.TeamCrest
import com.example.fuzechallenge.presentation.list.model.OpponentUIModel

@Composable
internal fun RowTeamImages(
    modifier: Modifier = Modifier,
    teams: List<OpponentUIModel>
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = dp40,
                start = dp16,
                end = dp16
            ),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TeamCrest(
            model = teams.firstOrNull(),
            modifier = modifier
        )
        Text(
            text = stringResource(R.string.vs_label),
            fontSize = sp12,
            color = Gray,
            textAlign = TextAlign.Center,
        )
        TeamCrest(
            model = teams.lastOrNull(),
            modifier = modifier
        )
    }
}

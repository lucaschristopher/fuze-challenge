package com.example.fuzechallenge.presentation.detail.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.commons.ui.components.EmptyTeamLogo
import com.example.fuzechallenge.presentation.commons.ui.components.LogoImage
import com.example.fuzechallenge.presentation.commons.ui.theme.Gray
import com.example.fuzechallenge.presentation.commons.ui.theme.dp10
import com.example.fuzechallenge.presentation.commons.ui.theme.dp60
import com.example.fuzechallenge.presentation.commons.ui.theme.sp12
import com.example.fuzechallenge.presentation.list.model.OpponentUIModel

@Composable
internal fun TeamCrest(
    modifier: Modifier = Modifier,
    model: OpponentUIModel?
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (model != null) LogoImage(modifier, model.opponent.imageUrl, dp60)
        else EmptyTeamLogo(modifier.size(dp60))

        Text(
            modifier = modifier.padding(top = dp10),
            text = model?.opponent?.name ?: stringResource(R.string.default_team_label),
            fontSize = sp12,
            color = Gray,
            textAlign = TextAlign.Center,
        )
    }
}

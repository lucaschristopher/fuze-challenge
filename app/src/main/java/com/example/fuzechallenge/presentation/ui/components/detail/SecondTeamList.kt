package com.example.fuzechallenge.presentation.ui.components.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.fuzechallenge.core.util.mockPlayerPreview
import com.example.fuzechallenge.presentation.model.detail.GangUiModel
import com.example.fuzechallenge.presentation.model.detail.PlayerUiModel
import com.example.fuzechallenge.presentation.theme.*
import com.example.fuzechallenge.presentation.ui.components.core.PlayerCard

@Composable
fun SecondTeamList(
    data: GangUiModel,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(items = data.players) { player ->
            PlayerCard(
                player = player,
                alignment = Alignment.TopStart,
                body = { BodySecondCardPlayer(player = player, modifier = modifier) }
            )
        }
    }
}

@Composable
fun BodySecondCardPlayer(player: PlayerUiModel, modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(dp2)
    ) {
        val (nickname, name) = createRefs()
        val startGuideline = createGuidelineFromEnd(af06)

        PlayerNickName(
            nickName = player.slug,
            modifier = modifier
                .fillMaxWidth(af04)
                .padding(top = dp8, start = dp8, end = dp8)
                .constrainAs(nickname) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(startGuideline)
                }
        )

        PlayerName(
            playerName = player.firstName,
            modifier = modifier
                .fillMaxWidth(af04)
                .padding(top = dp4, start = dp8, end = dp8)
                .constrainAs(name) {
                    top.linkTo(nickname.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(startGuideline)
                },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SecondTeamPlayerCardPreview() {
    FuzeChallengeTheme {
        PlayerCard(
            player = mockPlayerPreview,
            alignment = Alignment.TopStart,
            body = { BodySecondCardPlayer(player = mockPlayerPreview) })
    }
}
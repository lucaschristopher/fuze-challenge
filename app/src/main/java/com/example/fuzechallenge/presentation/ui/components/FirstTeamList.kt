package com.example.fuzechallenge.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.fuzechallenge.presentation.model.GangUIModel
import com.example.fuzechallenge.presentation.model.PlayerUIModel
import com.example.fuzechallenge.presentation.ui.theme.FuzeChallengeTheme
import com.example.fuzechallenge.presentation.ui.theme.af04
import com.example.fuzechallenge.presentation.ui.theme.dp2
import com.example.fuzechallenge.presentation.ui.theme.dp4
import com.example.fuzechallenge.presentation.ui.theme.dp8
import com.example.fuzechallenge.presentation.ui.utils.preview.MockPreview

@Composable
fun FirstTeamList(
    data: GangUIModel,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(items = data.players) { player ->
            PlayerCard(
                player = player,
                alignment = Alignment.TopEnd,
                body = { BodyFirstCardPlayer(player = player, modifier = modifier) }
            )
        }
    }
}

@Composable
fun BodyFirstCardPlayer(player: PlayerUIModel, modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(dp2)
    ) {
        val (nickname, name) = createRefs()
        val endGuideline = createGuidelineFromEnd(af04)

        PlayerNickName(
            nickName = player.slug,
            modifier = modifier
                .fillMaxWidth(af04)
                .padding(top = dp8, start = dp8, end = dp8)
                .constrainAs(nickname) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(endGuideline)
                }
        )

        PlayerName(
            playerName = player.firstName,
            modifier = modifier
                .fillMaxWidth(af04)
                .padding(top = dp4, start = dp8, end = dp8)
                .constrainAs(name) {
                    top.linkTo(nickname.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(endGuideline)
                },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FirstTeamPlayerCardPreview() {
    FuzeChallengeTheme {
        PlayerCard(
            player = MockPreview.mockPlayerUIModel,
            alignment = Alignment.TopEnd,
            body = { BodyFirstCardPlayer(player = MockPreview.mockPlayerUIModel) })
    }
}
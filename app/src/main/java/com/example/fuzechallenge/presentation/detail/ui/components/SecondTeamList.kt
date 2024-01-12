package com.example.fuzechallenge.presentation.detail.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.fuzechallenge.presentation.commons.ui.components.PlayerName
import com.example.fuzechallenge.presentation.commons.ui.components.PlayerNickName
import com.example.fuzechallenge.presentation.commons.ui.theme.FuzeChallengeTheme
import com.example.fuzechallenge.presentation.commons.ui.theme.af04
import com.example.fuzechallenge.presentation.commons.ui.theme.af06
import com.example.fuzechallenge.presentation.commons.ui.theme.dp2
import com.example.fuzechallenge.presentation.commons.ui.theme.dp4
import com.example.fuzechallenge.presentation.commons.ui.theme.dp8
import com.example.fuzechallenge.presentation.commons.utils.preview.MockPreview
import com.example.fuzechallenge.presentation.list.model.OpponentUIModel
import com.example.fuzechallenge.presentation.list.model.TeamUIModel

@Composable
internal fun SecondTeamList(
    modifier: Modifier = Modifier,
    data: OpponentUIModel
) {
    TeamCard(
        team = data.opponent,
        alignment = Alignment.TopStart,
        body = {
            BodySecondCardPlayer(
                modifier = modifier,
                team = data.opponent
            )
        }
    )
}

@Composable
internal fun BodySecondCardPlayer(
    modifier: Modifier = Modifier,
    team: TeamUIModel
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(dp2)
    ) {
        val (nickname, name) = createRefs()
        val startGuideline = createGuidelineFromEnd(af06)

        PlayerNickName(
            nickName = team.slug,
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
            playerName = team.name,
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
        TeamCard(
            team = MockPreview.mockTeamUIModel,
            alignment = Alignment.TopStart,
            body = { BodySecondCardPlayer(team = MockPreview.mockTeamUIModel) })
    }
}

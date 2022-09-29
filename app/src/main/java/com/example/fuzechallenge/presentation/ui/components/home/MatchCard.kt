package com.example.fuzechallenge.presentation.ui.components.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.fuzechallenge.presentation.model.*
import com.example.fuzechallenge.presentation.theme.*

@Composable
fun MatchCard(match: MatchUiModel) {
    Card(
        backgroundColor = DeepPurple,
        elevation = dp4,
        shape = RoundedCornerShape(dp16),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(dp6),
    ) {
        ConstraintLayout {
            val (rowTeamImages, divider, rowInfo, statusBadge) = createRefs()

            StatusBadge(
                scheduledAt = match.scheduledAt,
                matchStatus = match.status,
                modifier = Modifier.constrainAs(statusBadge) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            })

            RowTeamImages(
                modifier = Modifier.constrainAs(rowTeamImages) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
                match = match
            )

            Divider(
                color = Color.White.copy(alpha = af02),
                thickness = dp1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dp20)
                    .constrainAs(divider) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(rowTeamImages.bottom)
                    }
            )

            RowMatchInfo(
                match = match,
                modifier = Modifier
                    .constrainAs(rowInfo) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(divider.bottom)
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(top = dp10))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MatchCardPreview() {
    val beginAt = ""
    val status = ""
    val serie = SerieUiModel(
        id = 0,
        name = "Moscow",
        description = "",
        slug = "cs-go-epicenter-moscow-2016"
    )
    val league = LeagueUiModel(
        id = 4156,
        name = "EPICENTER",
        imageUrl = "https://cdn.pandascore.co/images/league/image/4156/600px-EPICENTER.svg.png",
        url = "",
        slug = "cs-go-epicenter"
    )
    val opponents = listOf(
        OpponentUiModel(
            type = "Time",
            opponent = TeamUiModel(
                id = 3288,
                imageUrl = "https://cdn.pandascore.co/images/team/image/3288/600px_virtus.pro_2019.png",
                name = "Virtus.pro",
                slug = "virtus-pro-75b4744b-43d9-4ebd-a8dc-f1e0f9be69b3",
                location = "RU"
            )
        ),
        OpponentUiModel(
            type = "Time",
            opponent = TeamUiModel(
                id = 3207,
                imageUrl = "https://cdn.pandascore.co/images/team/image/3207/SK_GAMMING.png",
                name = "SK",
                slug = "sk",
                location = "DE"
            )
        )
    )

    FuzeChallengeTheme {
        MatchCard(
            MatchUiModel(
                scheduledAt = beginAt,
                status = status,
                serie = serie,
                league = league,
                opponents = opponents
            )
        )
    }
}
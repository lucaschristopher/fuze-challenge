package com.example.fuzechallenge.presentation.ui.components.home

import androidx.compose.foundation.clickable
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
import com.example.fuzechallenge.core.constants.DEFAULT_ID
import com.example.fuzechallenge.core.util.*
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.theme.*

@Composable
fun MatchCard(
    match: MatchUiModel,
    openMatchDetail: (MatchUiModel) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        backgroundColor = DeepPurple,
        elevation = dp4,
        shape = RoundedCornerShape(dp16),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(dp6)
            .clickable {
                openMatchDetail(match)
            }
    ) {
        ConstraintLayout {
            val (rowTeamImages, divider, rowInfo, statusBadge) = createRefs()

            StatusBadge(
                scheduledAt = match.scheduledAt,
                matchStatus = match.status,
                modifier = modifier.constrainAs(statusBadge) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                })

            RowTeamImages(
                modifier = modifier.constrainAs(rowTeamImages) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
                match = match
            )

            Divider(
                color = Color.White.copy(alpha = af02),
                thickness = dp1,
                modifier = modifier
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
                modifier = modifier
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
    FuzeChallengeTheme {
        MatchCard(
            MatchUiModel(
                id = DEFAULT_ID,
                scheduledAt = mockBeginAtPreview,
                status = mockStatusPreview,
                serie = mockSeriePreview,
                league = mockLeaguePreview,
                opponents = mockOpponentsPreview
            ),
            openMatchDetail = {}
        )
    }
}
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.fuzechallenge.core.constants.ARG_MATCH
import com.example.fuzechallenge.core.util.*
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.navigation.Route
import com.example.fuzechallenge.presentation.theme.*

@Composable
fun MatchCard(
    match: MatchUiModel,
    navController: NavHostController
) {
    Card(
        backgroundColor = DeepPurple,
        elevation = dp4,
        shape = RoundedCornerShape(dp16),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(dp6)
            .clickable(
                onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(ARG_MATCH, match)
                    navController.navigate(Route.Detail.route)
                }
            )
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
    FuzeChallengeTheme {
        MatchCard(
            MatchUiModel(
                scheduledAt = mockBeginAtPreview,
                status = mockStatusPreview,
                serie = mockSeriePreview,
                league = mockLeaguePreview,
                opponents = mockOpponentsPreview
            ),
            navController = NavHostController(LocalContext.current)
        )
    }
}
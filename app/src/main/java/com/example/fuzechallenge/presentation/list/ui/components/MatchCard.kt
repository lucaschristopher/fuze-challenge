package com.example.fuzechallenge.presentation.list.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.fuzechallenge.presentation.commons.ui.components.RowTeamImages
import com.example.fuzechallenge.presentation.commons.ui.theme.DeepPurple
import com.example.fuzechallenge.presentation.commons.ui.theme.FuzeChallengeTheme
import com.example.fuzechallenge.presentation.commons.ui.theme.af02
import com.example.fuzechallenge.presentation.commons.ui.theme.dp1
import com.example.fuzechallenge.presentation.commons.ui.theme.dp10
import com.example.fuzechallenge.presentation.commons.ui.theme.dp16
import com.example.fuzechallenge.presentation.commons.ui.theme.dp20
import com.example.fuzechallenge.presentation.commons.ui.theme.dp4
import com.example.fuzechallenge.presentation.commons.ui.theme.dp6
import com.example.fuzechallenge.presentation.commons.utils.preview.MockPreview
import com.example.fuzechallenge.presentation.list.model.MatchUIModel

@Composable
internal fun MatchCard(
    modifier: Modifier = Modifier,
    match: MatchUIModel,
    openMatchDetail: (MatchUIModel) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = DeepPurple
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dp4
        ),
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
                teams = match.opponents
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
            match = MockPreview.mockMatchUIModel,
            openMatchDetail = {}
        )
    }
}

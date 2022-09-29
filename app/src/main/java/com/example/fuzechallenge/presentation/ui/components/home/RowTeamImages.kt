package com.example.fuzechallenge.presentation.ui.components.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.fuzechallenge.R
import com.example.fuzechallenge.core.constants.CANVA_DIVISOR
import com.example.fuzechallenge.presentation.model.MatchUiModel
import com.example.fuzechallenge.presentation.model.OpponentUiModel
import com.example.fuzechallenge.presentation.theme.*

@Composable
fun RowTeamImages(modifier: Modifier = Modifier, match: MatchUiModel) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = dp40, start = dp16, end = dp16),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TeamCrest(match.opponents.firstOrNull())
        Text(
            text = stringResource(R.string.vs_label),
            fontSize = sp12,
            color = Gray,
            textAlign = TextAlign.Center,
        )
        TeamCrest(match.opponents.lastOrNull())
    }
}

@Composable
private fun TeamCrest(model: OpponentUiModel?) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (model != null) LogoImage(model.opponent.imageUrl, dp60)
        else TeamEmptyLogo(Modifier.size(dp60))

        Text(
            modifier = Modifier.padding(top = dp10),
            text = model?.opponent?.name ?: stringResource(R.string.default_team_label),
            fontSize = sp12,
            color = Gray,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun LogoImage(imageUrl: String?, sizeImage: Dp) {
    SubcomposeAsyncImage(
        modifier = Modifier.size(sizeImage),
        model = imageUrl,
        contentDescription = stringResource(R.string.league_image_description)
    ) {

        when (painter.state) {
            is AsyncImagePainter.State.Loading -> CircularProgressIndicator(color = RedFuze)
            is AsyncImagePainter.State.Error -> TeamEmptyLogo()
            else -> SubcomposeAsyncImageContent()
        }
    }
}

@Composable
private fun TeamEmptyLogo(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawCircle(
            color = Gray,
            center = Offset(
                x = canvasWidth / CANVA_DIVISOR,
                y = canvasHeight / CANVA_DIVISOR
            ),
            radius = size.minDimension / CANVA_DIVISOR
        )
    }
}
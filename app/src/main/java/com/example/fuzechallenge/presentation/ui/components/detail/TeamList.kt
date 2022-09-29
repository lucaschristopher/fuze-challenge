package com.example.fuzechallenge.presentation.ui.components.detail

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.fuzechallenge.R
import com.example.fuzechallenge.core.constants.CANVA_DIVISOR
import com.example.fuzechallenge.core.util.mockPlayerPreview
import com.example.fuzechallenge.presentation.model.detail.GangUiModel
import com.example.fuzechallenge.presentation.model.detail.PlayerUiModel
import com.example.fuzechallenge.presentation.theme.*

@Composable
fun TeamList(data: GangUiModel) {
    LazyColumn() {
        items(items = data.players) { item ->
            PlayerCard(item)
        }
    }
}

@Composable
fun PlayerCard(player: PlayerUiModel) {
    Card(
        backgroundColor = DeepPurple,
        elevation = dp4,
        shape = RoundedCornerShape(dp16),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(dp6)
    ) {
        Row(
            horizontalArrangement = Arrangement.End
        ) {
            Column {
                Text(player.slug, fontSize = sp14, color = Color.White)
                Text("${player.firstName} ${player.lastName}", fontSize = sp12, color = Gray)
            }
            SubcomposeAsyncImage(
                modifier = Modifier.size(dp40),
                model = player.imageUrl,
                contentDescription = stringResource(R.string.player_image_description)
            ) {

                when (painter.state) {
                    is AsyncImagePainter.State.Loading -> CircularProgressIndicator(color = RedFuze)
                    is AsyncImagePainter.State.Error -> PlayerEmptyLogo()
                    else -> SubcomposeAsyncImageContent()
                }
            }
        }
    }
}

@Composable
fun PlayerEmptyLogo() {
    Canvas(Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawRoundRect(
            color = Gray,
            size = Size(
                width = canvasWidth / CANVA_DIVISOR,
                height = canvasHeight / CANVA_DIVISOR
            ),
            topLeft = Offset(dp16.toPx(), dp16.toPx()),
            cornerRadius = CornerRadius(dp16.toPx(), dp16.toPx())
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerCardPreview() {
    FuzeChallengeTheme {
        PlayerCard(player = mockPlayerPreview)
    }
}


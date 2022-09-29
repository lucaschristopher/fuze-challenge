package com.example.fuzechallenge.presentation.ui.components.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.fuzechallenge.R
import com.example.fuzechallenge.core.util.mockPlayerPreview
import com.example.fuzechallenge.presentation.model.detail.GangUiModel
import com.example.fuzechallenge.presentation.model.detail.PlayerUiModel
import com.example.fuzechallenge.presentation.theme.*

@Composable
fun TeamList(data: GangUiModel, isFirst: Boolean) {
    LazyColumn {
        items(items = data.players) { item ->
            PlayerCard(item, isFirst)
        }
    }
}

@Composable
fun PlayerCard(player: PlayerUiModel, isFirst: Boolean) {
    Card(
        backgroundColor = DeepPurple,
        elevation = dp4,
        shape = RoundedCornerShape(dp16),
        modifier = Modifier
            .width(dp200)
            .height(dp80)
            .padding(dp6)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (isFirst) Arrangement.End else Arrangement.Start
        ) {
            Column(
                modifier = Modifier.padding(dp6),
                horizontalAlignment = if (isFirst) Alignment.Start else Alignment.End,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(player.slug, fontSize = sp14, color = Color.White)
                Text(player.firstName, fontSize = sp12, color = Gray)
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
    Box(
        Modifier
            .padding(horizontal = dp8)
            .clip(RoundedCornerShape(dp4))
            .background(color = Gray)
            .width(dp40)
            .height(dp40)
    )
}

@Preview(showBackground = true)
@Composable
fun PlayerCardPreview() {
    FuzeChallengeTheme {
        PlayerCard(player = mockPlayerPreview, isFirst = true)
    }
}


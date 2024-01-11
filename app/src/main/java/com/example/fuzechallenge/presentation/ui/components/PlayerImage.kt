package com.example.fuzechallenge.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.model.PlayerUIModel
import com.example.fuzechallenge.presentation.ui.theme.dp10
import com.example.fuzechallenge.presentation.ui.theme.dp16
import com.example.fuzechallenge.presentation.ui.theme.dp60

@Composable
fun PlayerImage(
    player: PlayerUIModel,
    modifier: Modifier
) {
    SubcomposeAsyncImage(
        modifier = modifier
            .padding(horizontal = dp16)
            .clip(RoundedCornerShape(dp10))
            .background(Color.LightGray)
            .width(dp60)
            .height(dp60),
        model = player.imageUrl,
        contentDescription = stringResource(R.string.player_image_description)
    ) {

        when (painter.state) {
            is AsyncImagePainter.State.Loading -> LoadingComponent()
            is AsyncImagePainter.State.Error -> EmptyPlayerLogo()
            else -> SubcomposeAsyncImageContent()
        }
    }
}

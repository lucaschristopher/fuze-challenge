package com.example.fuzechallenge.presentation.ui.components.core

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.theme.RedFuze

@Composable
fun LogoImage(imageUrl: String?, sizeImage: Dp, modifier: Modifier = Modifier) {
    SubcomposeAsyncImage(
        modifier = modifier.size(sizeImage),
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

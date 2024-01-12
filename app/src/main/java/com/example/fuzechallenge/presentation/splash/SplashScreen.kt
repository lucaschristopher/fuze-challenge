package com.example.fuzechallenge.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.fuzechallenge.R
import com.example.fuzechallenge.commons.constants.Constants.ANIMATION_DURATION
import com.example.fuzechallenge.commons.constants.Constants.SPLASH_LOGO_DURATION
import com.example.fuzechallenge.presentation.commons.ui.theme.af0
import com.example.fuzechallenge.presentation.commons.ui.theme.af03
import com.example.fuzechallenge.presentation.commons.ui.theme.af2
import kotlinx.coroutines.delay

@Composable
internal fun SplashScreen( // FIXME
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit = {}
) {
    val scale = remember {
        Animatable(af0)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = af03,
            animationSpec = tween(
                durationMillis = SPLASH_LOGO_DURATION,
                easing = {
                    OvershootInterpolator(af2).getInterpolation(it)
                }
            )
        )
        delay(ANIMATION_DURATION)
        onNavigateToHome()
    }
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_fuze),
            contentDescription = stringResource(R.string.fuze_logo_description),
            modifier = modifier.scale(scale.value)
        )
    }
}
package org.fdev.website.presentation.screen.landing.composable

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutBack
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import fatigurqitiwebsite.composeapp.generated.resources.Res
import fatigurqitiwebsite.composeapp.generated.resources.me
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

@Composable
fun Me(size: Dp) {
    val scale = remember { Animatable(0.8f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        delay(300)
        launch {
            scale.animateTo(
                targetValue = 1f,
                animationSpec = tween(700, easing = EaseOutBack)
            )
        }
        launch {
            alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(500)
            )
        }
    }

    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .graphicsLayer(scaleX = scale.value, scaleY = scale.value, alpha = alpha.value)
            .background(darkColorScheme().onBackground),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(Res.drawable.me),
            contentDescription = "My photo",
            contentScale = ContentScale.Fit,
        )
    }
}
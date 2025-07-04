package org.fdev.website.presentation.composable.view

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutBack
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AppearAnimatedContent(
    modifier: Modifier = Modifier,
    show: Boolean,
    delay: Long = 300,
    content: @Composable () -> Unit
) {
    if (!show) return

    val scale = remember { Animatable(0.8f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        delay(delay)
        launch {
            scale.animateTo(
                targetValue = 1f, animationSpec = tween(700, easing = EaseOutBack)
            )
        }
        launch {
            alpha.animateTo(
                targetValue = 1f, animationSpec = tween(500)
            )
        }
    }

    Box(
        modifier = modifier.graphicsLayer(
            scaleX = scale.value,
            scaleY = scale.value,
            alpha = alpha.value
        )
    ) {
        content()
    }
}
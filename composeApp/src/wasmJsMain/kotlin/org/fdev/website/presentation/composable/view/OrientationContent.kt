package org.fdev.website.presentation.composable.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import org.fdev.website.presentation.screen.main.LocalScreenDetails

@Composable
fun OrientationContent(
    onPortrait: @Composable () -> Unit, onLandscape: @Composable () -> Unit
) {
    val isLandscape = LocalScreenDetails.current.isLandscape

    AnimatedVisibility(isLandscape) {
        onLandscape()
    }

    AnimatedVisibility(!isLandscape) {
        onPortrait()
    }
}
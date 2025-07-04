package org.fdev.website.presentation.screen.landing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.fdev.website.presentation.composable.view.OrientationContent

@Composable
fun LandingScreen(
    modifier: Modifier,
    onInfoClicked: () -> Unit
) {
    OrientationContent(
        onPortrait = { PortraitLandingScreen(modifier = modifier, onInfoClicked = onInfoClicked) },
        onLandscape = { LandscapeLandingScreen(modifier = modifier, onInfoClicked = onInfoClicked) }
    )
}
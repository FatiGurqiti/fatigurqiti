package org.fdev.website.presentation.screen.about

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.fdev.website.presentation.composable.view.OrientationContent

@Composable
fun AboutScreen(
    modifier: Modifier, onLetsTalkClicked: () -> Unit
) {
    OrientationContent(
        onPortrait = {
            PortraitAboutScreen(
                modifier = modifier, onLetsTalkClicked = onLetsTalkClicked
            )
        },
        onLandscape = {
            LandscapeAboutScreen(
                modifier = modifier, onLetsTalkClicked = onLetsTalkClicked
            )
        }
    )
}
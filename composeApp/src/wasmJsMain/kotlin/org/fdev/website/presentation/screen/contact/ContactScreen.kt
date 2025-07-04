package org.fdev.website.presentation.screen.contact

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.browser.window
import org.fdev.website.common.Constants.EMAIL
import org.fdev.website.common.Constants.LINKED_IN_URL
import org.fdev.website.presentation.composable.view.OrientationContent

@Composable
fun ContactScreen(modifier: Modifier) {
    val onLinkedInClicked = {
        window.open(LINKED_IN_URL, "_blank")
    }

    val onEmailClicked = {
        window.open("mailto:$EMAIL", "_self")
    }

    OrientationContent(
        onPortrait = {
            PortraitContactScreen(
                modifier = modifier,
                onLinkedInClicked = { onLinkedInClicked() },
                onEmailClicked = { onEmailClicked() }
            )
        },
        onLandscape = {
            LandscapeContactScreen(
                modifier = modifier,
                onLinkedInClicked = { onLinkedInClicked() },
                onEmailClicked = { onEmailClicked() }
            )
        }
    )
}
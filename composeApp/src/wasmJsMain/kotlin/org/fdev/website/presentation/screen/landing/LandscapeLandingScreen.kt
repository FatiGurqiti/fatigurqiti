package org.fdev.website.presentation.screen.landing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.fdev.website.presentation.screen.landing.composable.Me
import org.fdev.website.presentation.screen.landing.composable.MyDetails

@Composable
fun LandscapeLandingScreen(modifier: Modifier, onInfoClicked: () -> Unit) {
    Row(modifier = modifier) {
        Box(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(.5f),
            contentAlignment = Alignment.Center
        ) {
            MyDetails(onInfoClicked = onInfoClicked)
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Me(300.dp)
        }
    }
}
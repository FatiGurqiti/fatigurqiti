package org.fdev.website.presentation.screen.landing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.fdev.website.presentation.screen.landing.composable.Me
import org.fdev.website.presentation.screen.landing.composable.MyDetails

@Composable
fun PortraitLandingScreen(modifier: Modifier, onInfoClicked: () -> Unit) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Spacer(Modifier.size(50.dp))
        Me(250.dp)
        Spacer(Modifier.size(22.dp))
        MyDetails(onInfoClicked = onInfoClicked)
        Spacer(Modifier.size(22.dp))
    }
}
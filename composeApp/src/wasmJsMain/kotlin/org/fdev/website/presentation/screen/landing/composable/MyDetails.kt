package org.fdev.website.presentation.screen.landing.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.fdev.website.presentation.composable.button.AppOutlinedTextButton
import org.fdev.website.presentation.composable.text.AppText
import org.fdev.website.presentation.theme.androidGreen

@Composable
fun MyDetails(onInfoClicked: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppText(
            modifier = Modifier.fillMaxWidth(),
            text = "Fati Gurqiti",
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center
        )

        AppText(
            modifier = Modifier.fillMaxWidth(),
            text = "Android Developer",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.size(22.dp))

        AppText(
            modifier = Modifier.fillMaxWidth(),
            text = "Speak, friend, and deploy.",
            style = MaterialTheme.typography.bodyLarge.copy(fontStyle = FontStyle.Italic),
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.size(22.dp))

        AppOutlinedTextButton(
            modifier = Modifier.width(150.dp).height(50.dp),
            onClick = onInfoClicked,
            text = "Let's meet!",
            borderColor = androidGreen,
            textAlign = TextAlign.Center
        )
    }
}
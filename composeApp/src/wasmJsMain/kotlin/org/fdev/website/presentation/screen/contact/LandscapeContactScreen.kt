package org.fdev.website.presentation.screen.contact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fatigurqitiwebsite.composeapp.generated.resources.Res
import fatigurqitiwebsite.composeapp.generated.resources.linkedin
import org.fdev.website.presentation.composable.button.AppImageButton
import org.fdev.website.presentation.composable.button.BlueButton
import org.fdev.website.presentation.composable.text.AppText
import org.jetbrains.compose.resources.painterResource

@Composable
fun LandscapeContactScreen(
    modifier: Modifier,
    onLinkedInClicked: () -> Unit,
    onEmailClicked: () -> Unit
) {
    Column(
        modifier = modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        Spacer(Modifier.size(32.dp))

        AppText(
            text = "Let's connect!",
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center
        )
        AppText(
            text = "Glad to have your attention, stranger. Sorry if this took too long, but I had to fill up the gaps. Here's a fact that might interest you; I made this whole website using Kotlin Multiplatform. Cool right? Anyway, you may find ways to contact me down below. Do not hesitate pick whichever fits you best. I really don't mind.\nSee you soon :)",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.size(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            AppImageButton(
                modifier = Modifier.width(200.dp).height(75.dp),
                painter = painterResource(Res.drawable.linkedin),
                contentDescription = "Linkedin",
                onClick = onLinkedInClicked
            )

            Spacer(Modifier.size(22.dp))

            BlueButton(
                modifier = Modifier.width(200.dp).height(75.dp),
                onClick = onEmailClicked,
                text = "E-mail"
            )
        }
    }
}
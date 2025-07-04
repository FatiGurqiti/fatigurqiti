package org.fdev.website.presentation.screen.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.fdev.website.presentation.composable.text.AppText
import org.fdev.website.presentation.composable.view.AppearAnimatedContent
import org.fdev.website.presentation.screen.about.composable.MyNameTypeWriterText
import org.fdev.website.presentation.screen.about.composable.StillHere
import org.fdev.website.presentation.theme.androidGreen
import org.fdev.website.presentation.theme.coolBlue
import org.fdev.website.presentation.theme.lightRed
import org.fdev.website.presentation.theme.mindliftOrange

@Composable
fun PortraitAboutScreen(modifier: Modifier, onLetsTalkClicked: () -> Unit) {
    var showContent by remember { mutableStateOf(false) }

    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyNameTypeWriterText {
            showContent = true
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 22.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            AppearAnimatedContent(
                modifier = Modifier.fillMaxWidth(),
                show = showContent,
                delay = 300
            ) {
                AppText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Let's not bore each other",
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 28.sp),
                    textColor = androidGreen,
                    textAlign = TextAlign.Start
                )
            }

            AppearAnimatedContent(
                modifier = Modifier.fillMaxWidth(),
                show = showContent,
                delay = 1000
            ) {
                AppText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "I make mobile apps",
                    style = MaterialTheme.typography.titleLarge,
                    textColor = coolBlue,
                    textAlign = TextAlign.End
                )
            }

            AppearAnimatedContent(
                modifier = Modifier.fillMaxWidth(),
                show = showContent,
                delay = 2000
            ) {
                AppText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Good ones",
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
                    textColor = lightRed,
                    textAlign = TextAlign.Start
                )
            }

            AppearAnimatedContent(
                modifier = Modifier.fillMaxWidth(),
                show = showContent,
                delay = 3000
            ) {
                AppText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Oh, and I make the process fun",
                    style = MaterialTheme.typography.titleLarge,
                    textColor = mindliftOrange,
                    textAlign = TextAlign.End
                )
            }

            AppearAnimatedContent(
                modifier = Modifier,
                show = showContent,
                delay = 4000
            ) {
                StillHere(
                    onMyWorkClicked = { },
                    onLetsTalkClicked = onLetsTalkClicked,
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }
    }
}
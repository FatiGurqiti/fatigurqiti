package org.fdev.website.presentation.screen.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun LandscapeAboutScreen(modifier: Modifier, onLetsTalkClicked: () -> Unit) {
    var showContent by remember { mutableStateOf(false) }

    Column(
        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyNameTypeWriterText {
            showContent = true
        }

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier.fillMaxWidth(.7f), contentAlignment = Alignment.TopCenter
                ) {
                    AppearAnimatedContent(
                        show = showContent, delay = 300
                    ) {
                        AppText(
                            text = "Let's not bore each other",
                            style = MaterialTheme.typography.headlineLarge.copy(fontSize = 42.sp),
                            textColor = androidGreen
                        )
                    }
                }

                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter
                ) {
                    AppearAnimatedContent(
                        show = showContent, delay = 1000
                    ) {
                        AppText(
                            text = "I make mobile apps",
                            style = MaterialTheme.typography.headlineLarge,
                            textColor = coolBlue
                        )
                    }
                }
            }

            Row {
                Box(
                    modifier = Modifier.fillMaxWidth(.4f), contentAlignment = Alignment.TopCenter
                ) {
                    AppearAnimatedContent(
                        show = showContent, delay = 2000
                    ) {
                        AppText(
                            text = "Good ones",
                            style = MaterialTheme.typography.headlineLarge,
                            textColor = lightRed
                        )
                    }
                }

                Box(
                    modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter
                ) {
                    AppearAnimatedContent(
                        show = showContent, delay = 3000
                    ) {
                        AppText(
                            text = "Oh, and I make the process fun",
                            style = MaterialTheme.typography.headlineLarge.copy(fontSize = 48.sp),
                            textColor = mindliftOrange
                        )
                    }
                }
            }

            AppearAnimatedContent(
                show = showContent, delay = 4000
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
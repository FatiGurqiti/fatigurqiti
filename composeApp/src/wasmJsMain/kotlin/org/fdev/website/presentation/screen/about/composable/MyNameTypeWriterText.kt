package org.fdev.website.presentation.screen.about.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.fdev.website.presentation.composable.text.TypewriterText

@Composable
fun MyNameTypeWriterText(onAnimationFinished: () -> Unit) {
    TypewriterText(
        modifier = Modifier
            .padding(22.dp),
        fullText = "Hi, I'm Fati...",
        onAnimationFinished = onAnimationFinished
    )
}
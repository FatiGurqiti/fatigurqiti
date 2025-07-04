package org.fdev.website.presentation.composable.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.fdev.website.presentation.composable.util.isElementVisible
import org.fdev.website.presentation.theme.CourierPrimeFamily

@Composable
fun TypewriterText(
    modifier: Modifier,
    fullText: String,
    speed: Long = 120L,
    showCursor: Boolean = true,
    onAnimationFinished: () -> Unit
) {
    var visibleText by remember { mutableStateOf(" ") }
    var index by remember { mutableStateOf(0) }
    var isVisible by remember { mutableStateOf(false) }

    // Animate the typing
    if (isVisible) {
        LaunchedEffect(fullText) {
            while (index <= fullText.length) {
                visibleText = fullText.substring(0, index)
                index++
                delay(speed)
            }

            onAnimationFinished()
        }
    }

    // Optional blinking cursor
    val cursorChar = remember { mutableStateOf(" ") }
    if (showCursor) {
        LaunchedEffect(Unit) {
            while (true) {
                cursorChar.value = "|"
                delay(500)
                cursorChar.value = " "
                delay(500)
            }
        }
    }

    // Text with a typewriter font
    Text(
        modifier = modifier.isElementVisible { isVisible = it },
        text = visibleText + cursorChar.value,
        fontSize = 58.sp,
        fontFamily = CourierPrimeFamily(),
        fontWeight = FontWeight.Bold,
        style = TextStyle(letterSpacing = 1.2.sp),
        lineHeight = 55.sp,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        color = Color.White
    )
}

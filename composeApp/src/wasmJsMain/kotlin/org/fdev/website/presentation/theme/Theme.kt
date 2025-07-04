package org.fdev.website.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color.Black,
    onPrimary = Color(0xFFB1B0B0),
    secondary = Color.White,
    onSecondary = Color.Black,
    background = Color(0xFF292F33),
    surface = Color(0xFFFFFFFF),
    onSurface = Color.Black,
    error = Color(0xFFB00020),
    onError = Color.White,
    surfaceTint = lightGray
)


private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    onPrimary = Color(0xFF797979),
    secondary = Color.Black,
    onSecondary = Color.White,
    background = Color(0xFFFFFFFF),
    surface = Color(0xFF121212),
    onSurface = Color.White,
    error = Color(0xFFCF6679),
    onError = Color.Black,
    surfaceTint = Color(0xFF445668)
)

@Composable
fun FatiGurqitiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}
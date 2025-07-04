package org.fdev.website.domain.module

import androidx.compose.ui.unit.dp

data class ScreenDetails(
    val width: Int,
    val height: Int,
) {
    val isLandscape: Boolean = width > height
    val widthDp = width.dp
    val heightDp = height.dp -55.dp // 55 is the height of the navigation bar
}

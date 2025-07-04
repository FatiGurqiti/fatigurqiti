package org.fdev.website.presentation.composable.divier

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun AppHorizontalDivider(){
    HorizontalDivider(
        color = darkColorScheme().onBackground,
        thickness = 0.5.dp
    )
}
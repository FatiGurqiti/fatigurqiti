package org.fdev.website.presentation.screen.navigationBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.fdev.website.domain.enumuration.NavigationItem
import org.fdev.website.domain.module.UiItem
import org.fdev.website.presentation.composable.button.AppTextButton
import org.fdev.website.presentation.composable.divier.AppHorizontalDivider

@Composable
fun LandscapeNavigationBar(
    navigationItems: List<UiItem<NavigationItem>>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(navigationItems) {
                AppTextButton(
                    text = it.name,
                    onClick = it.onClick
                )
            }
        }

        AppHorizontalDivider()
    }
}
package org.fdev.website.presentation.screen.navigationBar

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.fdev.website.domain.enumuration.NavigationItem
import org.fdev.website.domain.module.UiItem
import org.fdev.website.presentation.composable.button.AppTextButton
import org.fdev.website.presentation.screen.main.LocalScreenDetails

@Composable
fun PortraitNavigationBar(
    navigationItems: List<UiItem<NavigationItem>>, isExpanded: Boolean, onIconClicked: () -> Unit
) {
    val screenDetails = LocalScreenDetails.current


    Column(
        verticalArrangement = Arrangement.Top
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().height(55.dp).padding(start = 22.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            IconButton(
                modifier = Modifier.pointerHoverIcon(PointerIcon.Hand), onClick = onIconClicked
            ) {
                AnimatedContent(targetState = isExpanded) { expanded ->
                    val icon: ImageVector =
                        if (!expanded) Icons.Rounded.Menu else Icons.Rounded.Close

                    Box(
                        modifier = Modifier.size(40.dp).border(
                            width = 1.dp,
                            color = Color.White,
                            shape = CircleShape
                        ), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(.75f),
                            tint = Color.White
                        )
                    }
                }
            }
        }

        AnimatedVisibility(isExpanded) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth().height(screenDetails.heightDp)
                    .padding(start = 22.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                items(navigationItems) {
                    AppTextButton(
                        modifier = Modifier.fillMaxSize(),
                        text = it.name,
                        onClick = it.onClick,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
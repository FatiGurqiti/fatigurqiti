package org.fdev.website.presentation.screen.navigationBar

import androidx.compose.runtime.Composable
import org.fdev.website.domain.enumuration.NavigationItem
import org.fdev.website.domain.module.UiItem
import org.fdev.website.presentation.composable.view.OrientationContent

@Composable
fun NavigationBar(
    isExpanded: Boolean,
    onItemClicked: (NavigationItem) -> Unit,
    onIconClicked: () -> Unit,
) {
    val navigationItems = listOf<UiItem<NavigationItem>>(
        UiItem<NavigationItem>(
            item = NavigationItem.HOME,
            name = "Home",
            onClick = {
                onItemClicked(NavigationItem.HOME)
            }
        ),
        UiItem<NavigationItem>(
            item = NavigationItem.ABOUT,
            name = "About",
            onClick = {
                onItemClicked(NavigationItem.ABOUT)
            }
        ),
//        UiItem<NavigationItem>( TODO("To be added")
//            item = NavigationItem.PORTFOLIO,
//            name = "Portfolio",
//            onClick = {
//                if (isExpanded) {
//                    isExpanded = !isExpanded
//                }
//            }
//        ),
        UiItem<NavigationItem>(
            item = NavigationItem.CONTACT,
            name = "Contact",
            onClick = {
                onItemClicked(NavigationItem.CONTACT)
            }
        ),
        UiItem<NavigationItem>(
            item = NavigationItem.RESUME,
            name = "Resume",
            onClick = {
                onItemClicked(NavigationItem.RESUME)
            }
        )
    )

    OrientationContent(onPortrait = {
        PortraitNavigationBar(
            navigationItems = navigationItems,
            isExpanded = isExpanded,
            onIconClicked = onIconClicked
        )
    }, onLandscape = {
        LandscapeNavigationBar(navigationItems = navigationItems)
    })
}
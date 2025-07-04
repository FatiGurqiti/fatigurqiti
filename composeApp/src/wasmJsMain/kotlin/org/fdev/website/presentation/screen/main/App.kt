package org.fdev.website.presentation.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import kotlinx.browser.window
import org.fdev.website.common.Constants.CV_URL
import org.fdev.website.domain.enumuration.NavigationItem
import org.fdev.website.domain.module.ScreenDetails
import org.fdev.website.presentation.composable.util.appAnimateScroll
import org.fdev.website.presentation.screen.about.AboutScreen
import org.fdev.website.presentation.screen.contact.ContactScreen
import org.fdev.website.presentation.screen.landing.LandingScreen
import org.fdev.website.presentation.screen.navigationBar.NavigationBar
import org.fdev.website.presentation.theme.FatiGurqitiTheme
import org.fdev.website.presentation.theme.background

val LocalScreenDetails = staticCompositionLocalOf<ScreenDetails> {
    ScreenDetails(
        width = window.innerWidth, height = window.innerHeight
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App() {
    val scrollState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    var screenWidth by remember { mutableStateOf(window.innerWidth) }
    var screenHeight by remember { mutableStateOf(window.innerHeight) }
    var isNavigationBar by remember { mutableStateOf(false) }

    val screenDetails = ScreenDetails(
        width = screenWidth, height = screenHeight
    )

    val navigationBarToggle = {
        isNavigationBar = !isNavigationBar
    }

    val goToHome = {
        scrollState.appAnimateScroll(scope = scope, 0)
    }

    val goToAbout = {
        scrollState.appAnimateScroll(scope = scope, 1)
    }

    val goToContact = {
        scrollState.appAnimateScroll(scope = scope, 2)
    }

    val onNavigationItemClicked: (NavigationItem) -> Unit = {
        when (it) {
            NavigationItem.HOME -> {
                goToHome()
            }

            NavigationItem.ABOUT -> {
                goToAbout()
            }

            NavigationItem.CONTACT -> {
                goToContact()
            }

            NavigationItem.RESUME -> {
                window.open(CV_URL, "_blank")
            }
        }

        navigationBarToggle()
    }

    DisposableEffect(Unit) {
        window.addEventListener("resize") {
            screenWidth = window.innerWidth
            screenHeight = window.innerHeight
        }
        onDispose {
            window.removeEventListener("resize") {
                screenWidth = window.innerWidth
                screenHeight = window.innerHeight
            }
        }
    }

    AppView(
        screenDetails = screenDetails,
        isNavigationBar = isNavigationBar,
        onNavigationIconClicked = { navigationBarToggle() },
        onNavigationItemClicked = onNavigationItemClicked,
        scrollState = scrollState,
        onInfoClicked = { goToAbout() },
        onLetsTalkClicked = { goToContact() },
    )
}

@Composable
fun AppView(
    screenDetails: ScreenDetails,
    isNavigationBar: Boolean,
    onNavigationIconClicked: () -> Unit,
    onNavigationItemClicked: (NavigationItem) -> Unit,
    scrollState: LazyListState,
    onInfoClicked: () -> Unit,
    onLetsTalkClicked: () -> Unit,
) {
    FatiGurqitiTheme {
        CompositionLocalProvider(LocalScreenDetails provides screenDetails) {
            val heightModifier = Modifier.fillMaxWidth().height(screenDetails.heightDp)

            Column(
                modifier = Modifier.fillMaxSize().safeContentPadding().background(background)
            ) {
                NavigationBar(
                    isExpanded = isNavigationBar,
                    onIconClicked = onNavigationIconClicked,
                    onItemClicked = { onNavigationItemClicked(it) })

                LazyColumn(
                    modifier = Modifier.fillMaxSize(), state = scrollState
                ) {
                    item {
                        LandingScreen(
                            modifier = heightModifier, onInfoClicked = onInfoClicked
                        )
                    }

                    item {
                        AboutScreen(
                            modifier = heightModifier, onLetsTalkClicked = onLetsTalkClicked
                        )
                    }

                    item {
                        ContactScreen(modifier = heightModifier)
                    }
                }
            }
        }
    }
}

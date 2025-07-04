package org.fdev.website.presentation.composable.util

import androidx.compose.foundation.lazy.LazyListState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun LazyListState.appAnimateScroll(scope: CoroutineScope, targetIndex: Int) {
    scope.launch {
        animateScrollToItem(targetIndex)
    }
}

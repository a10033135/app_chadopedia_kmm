package ui.tabs

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.transitions.SlideTransition

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Tab.TabContent(screen: Screen) {
    val tabTitle = options.title

    LifecycleEffect(
        onStarted = { println("Navigator Start tab $tabTitle") },
        onDisposed = { println("Navigator Dispose tab $tabTitle") }
    )
    Navigator(screen) { navigator ->
        SlideTransition(
            navigator = navigator,
            modifier = Modifier.fillMaxSize(),
        ) {
            it.Content()
        }
    }
}

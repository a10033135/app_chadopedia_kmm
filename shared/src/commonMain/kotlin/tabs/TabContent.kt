package tabs

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.transitions.SlideTransition
import home.HomeScreen
import secondScreen.SecondScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Tab.TabContent(screen: Screen) {
    val tabTitle = options.title

    LifecycleEffect(
        onStarted = { println("Navigator Start tab $tabTitle") },
        onDisposed = { println("Navigator Dispose tab $tabTitle") }
    )

    Navigator(screen) { navigator ->
        SlideTransition(navigator) { screen ->
            Column {
                screen.Content()
                println("Navigator Last Event: ${navigator.lastEvent}")
            }
        }
    }
}

package screen

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import functions.getChadoContent
import kotlinx.coroutines.launch
import org.lighthousegames.logging.logging
import ui.tabs.FavoritesTab
import ui.tabs.HomeTab
import ui.tabs.ProfileTab

@OptIn(ExperimentalVoyagerApi::class)
@Composable
fun App() {

    MaterialTheme(colors = Theme.colors) {
        TabNavigator(HomeTab, tabDisposable = {
            TabDisposable(
                navigator = it,
                tabs = listOf(HomeTab, FavoritesTab, ProfileTab)
            )
        }) { tabNavigator ->

            Scaffold(
                topBar = {
                    TopAppBar(title = {
                        Text(text = tabNavigator.current.options.title)
                    })
                },
                content = {
                    CurrentTab()
                },
                bottomBar = {
                    BottomNavigation {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(FavoritesTab)
                        TabNavigationItem(ProfileTab)
                    }
                }
            )
        }
    }
}

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) }
    )
}
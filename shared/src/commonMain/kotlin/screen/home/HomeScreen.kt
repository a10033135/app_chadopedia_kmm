package screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import db.Database
import db.DatabaseDriverFactory
import functions.getChadoContent
import functions.getMainCate
import kotlinx.coroutines.launch
import model.MainCategory
import org.lighthousegames.logging.logging
import screen.second.SecondScreen
import ui.card.MainCard

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val greetingText by remember { mutableStateOf("Hello, World!") }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navigator.push(SecondScreen()) }
            ) {
                Text(greetingText)
            }
        }

        val a = rememberCoroutineScope()
        val (main, setMain) = remember { mutableStateOf<List<MainCategory>>(listOf()) }
        a.launch {
            println("getMainCate")
            val tag = logging("App")
            val mainCategory = getMainCate()
            setMain(mainCategory)
            logging("Main").e { "mainCategory: $mainCategory" }
        }

        Column {
            main.forEach { _ ->
                Database(DatabaseDriverFactory())
                MainCard()
            }
        }
    }

}
package screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
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
import cloudinary.Cloudinary
import db.Database
import functions.getChadoContent
import functions.getMainCate
import kotlinx.coroutines.launch
import model.ChadoContent
import model.MainCategory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.lighthousegames.logging.logging
import screen.second.SecondScreen
import ui.card.RectCard
import ui.card.SquareCard

class HomeScreen : Screen, KoinComponent {

    private val database by inject<Database>()

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
        val (main, setMain) = remember { mutableStateOf<List<ChadoContent>>(listOf()) }
        a.launch {
            println("getMainCate")
            val tag = logging("App")
            val mainCategory = getChadoContent()
            setMain(mainCategory)
            logging("Main").e { "mainCategory: $mainCategory" }
        }


        database.mainCategoriesQueries.queryAllMainCategory().executeAsList().forEach {
            logging("database").e { "mainCategory: $it" }
        }

        LazyColumn {
            main.forEach {
                item {
                    RectCard(
                        title = it.title,
                        desc = it.desc,
                        hasImage = it.has_image,
                        imgUrl = "${Cloudinary.URL_CHADO_CONTENT}${it.id}.png}"
                    )
                    logging("Main").e { "${Cloudinary.URL_CHADO_CONTENT}${it.id}.png" }
                }

            }
        }
    }

}
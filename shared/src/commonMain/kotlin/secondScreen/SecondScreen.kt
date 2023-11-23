package secondScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen

class SecondScreen : Screen {
    @Composable
    override fun Content() {

        Box(
            modifier = Modifier
                .wrapContentSize()
                .background(Color.Red)
        ) {

            Text("SecondScreen")

        }

    }
}
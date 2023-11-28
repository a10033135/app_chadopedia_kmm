package screen

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object Theme {

    val colors: Colors
        @Composable
        get() = Colors(
            primary = primaryColor,
            primaryVariant = primaryVariantColor,
            secondary = secondaryColor,
            secondaryVariant = secondaryVariantColor,
            background = backgroundColor,
            surface = surfaceColor,
            error = errorColor,
            onPrimary = onPrimaryColor,
            onSecondary = onSecondaryColor,
            onBackground = onBackgroundColor,
            onSurface = onSurfaceColor,
            onError = onErrorColor,
            isLight = isLightTheme
        )

    val primaryColor: Color
        @Composable
        get() = Color.Blue

    val primaryVariantColor: Color
        @Composable
        get() = Color.Blue

    val secondaryColor: Color
        @Composable
        get() = Color.Blue

    val secondaryVariantColor: Color
        @Composable
        get() = Color.Blue

    val backgroundColor: Color
        @Composable
        get() = Color.White

    val surfaceColor: Color
        @Composable
        get() = Color.White

    val errorColor: Color
        @Composable
        get() = Color.Red

    val onPrimaryColor: Color
        @Composable
        get() = Color.White

    val onSecondaryColor: Color
        @Composable
        get() = Color.White

    val onBackgroundColor: Color
        @Composable
        get() = Color.Black

    val onSurfaceColor: Color
        @Composable
        get() = Color.Black

    val onErrorColor: Color
        @Composable
        get() = Color.White

    val isLightTheme: Boolean
        @Composable
        get() = false
}
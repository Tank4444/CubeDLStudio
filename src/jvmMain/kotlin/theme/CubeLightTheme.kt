package theme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font
import theme.colors.CubeColors
import theme.colors.LocalColors
import theme.colors.darkPalette

@Composable
fun CubeTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides darkPalette,
        content = content
    )
}

object Cube {
    val color: CubeColors
        @Composable
        get() = LocalColors.current
}
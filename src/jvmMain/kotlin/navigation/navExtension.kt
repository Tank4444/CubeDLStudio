package navigation

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import androidx.compose.ui.awt.ComposePanel
import kotlinx.html.InputType
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import theme.CubeLightTheme
import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.WindowConstants

fun JFrame.setupThemedNavigation(
    startScreen:String,
    vararg providers: ProvidedValue<*>,
    navigationGraph: RootComposeBuilder.()->Unit
){
    val composePanel = ComposePanel()

    composePanel.setContent {
        CubeLightTheme {
            val rootController = RootComposeBuilder()
                .apply(navigationGraph).build()

            CompositionLocalProvider(
                *providers,
                LocalRootController provides rootController
            ) {
                ModalNavigator {
                    Navigator(startScreen)
                }
            }
        }
    }

    defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    contentPane.add(composePanel,BorderLayout.CENTER)
    setLocationRelativeTo(null)
    isVisible = true
}
// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import components.first
import components.second
import navigation.NavigationTree
import navigation.setupThemedNavigation
import ru.alexgladkov.odyssey.compose.extensions.customNavigation
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.BottomNavConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabsNavModel
import ru.alexgladkov.odyssey.compose.setupNavigation
import theme.CubeLightTheme
import javax.swing.JFrame
import javax.swing.JFrame.setDefaultLookAndFeelDecorated
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

@Preview
fun main() = SwingUtilities.invokeLater {
//    val windowState = WindowState()
//
//    singleWindowApplication(
//        state = windowState,
//        title = "Hello app",
//    ) {
//        CubeLightTheme {
//            val rootController = LocalRootController.current
//            rootController.push("hello")
//        }
//    }
//    import ru.alexgladkov.common.compose.NavigationTree
//            import ru.alexgladkov.common.compose.navigation.navigationGraph
    val window = JFrame()
    window.title = "Hello"
    window.setSize(800,600)
    setDefaultLookAndFeelDecorated(true)
    window.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    window.isVisible = true
    window.setSize(600, 600)

    window.setupNavigation("hello"){
        screen("first"){
            first()
        }
        screen("second"){
            second()
        }
    }
}

fun RootComposeBuilder.helloScreen(){
    screen("hello"){ first() }
}

class BottomConfiguration : TabsNavModel<BottomNavConfiguration>() {

    override val navConfiguration: BottomNavConfiguration
        @Composable
        get() {
            return BottomNavConfiguration(
                backgroundColor = Color.Blue,
                selectedColor = Color.White,
                unselectedColor = Color.White
            )
        }
}
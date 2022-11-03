package navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.BottomNavConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.CustomNavConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabsNavModel
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TopNavConfiguration
import theme.Cube

class BottomConfiguration : TabsNavModel<BottomNavConfiguration>() {

    override val navConfiguration: BottomNavConfiguration
        @Composable
        get() {
            return BottomNavConfiguration(
                backgroundColor = Cube.color.secondaryBackground,
                selectedColor = Cube.color.primaryText,
                unselectedColor = Cube.color.controlColor,
                elevation = 0.dp
            )
        }
}

class TopConfiguration : TabsNavModel<TopNavConfiguration>() {

    override val navConfiguration: TopNavConfiguration
        @Composable
        get() {
            return TopNavConfiguration(
                backgroundColor = Cube.color.secondaryBackground,
                contentColor = Cube.color.primaryText
            )
        }
}

class CustomConfiguration(private val content: @Composable (params: Any?) -> Unit) :
    TabsNavModel<CustomNavConfiguration>() {

    override val navConfiguration: CustomNavConfiguration
        @Composable
        get() {
            return CustomNavConfiguration(
                content = content
            )
        }
}
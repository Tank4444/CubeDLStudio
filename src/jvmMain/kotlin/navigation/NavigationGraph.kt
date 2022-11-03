package navigation

import ru.alexgladkov.odyssey.compose.extensions.customNavigation
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.navigationGraph() {
    screen(NavigationTree.Actions.name) {
        ActionsScreen(count = 0)
    }

    screen(NavigationTree.Push.name) {
        ActionsScreen(count = it as? Int)
    }

    flow(NavigationTree.Present.name) {
        screen(NavigationTree.PresentScreen.name) {
            PresentedActionsScreen(count = (it as? Int) ?: 0)
        }
    }

    mainScreen()
    topNavScreen()
    customNavScreen()
}

fun RootComposeBuilder.mainScreen() {
    bottomNavigation(name = NavigationTree.Main.name, tabsNavModel = BottomConfiguration()) {
        tab(FeedTab()) {
            screen(name = NavigationTree.Tab.name) {
                TabScreen(it as? Int)
            }
        }
        tab(SearchTab()) {
            screen(name = NavigationTree.Tab.name) {
                TabScreen(it as? Int)
            }
        }
        tab(CartTab()) {
            screen(name = NavigationTree.Tab.name) {
                TabScreen(it as? Int)
            }
        }
    }
}

fun RootComposeBuilder.topNavScreen() {
    topNavigation(name = NavigationTree.Top.name, tabsNavModel = TopConfiguration()) {
        tab(FeedTab()) {
            screen(name = NavigationTree.Tab.name) {
                TabScreen(it as? Int)
            }
        }
        tab(SearchTab()) {
            screen(name = NavigationTree.Tab.name) {
                TabScreen(it as? Int)
            }
        }
        tab(CartTab()) {
            screen(name = NavigationTree.Tab.name) {
                TabScreen(it as? Int)
            }
        }
    }
}

fun RootComposeBuilder.customNavScreen() {
    customNavigation(name = NavigationTree.Drawer.name, tabsNavModel = CustomConfiguration(
        content = { params -> DrawerScreen(params) }
    )) {
        tab(FeedTab()) {
            screen(name = NavigationTree.Tab.name) {
                TabScreen(it as? Int)
            }
        }
        tab(SearchTab()) {
            screen(name = NavigationTree.Tab.name) {
                TabScreen(it as? Int)
            }
        }
        tab(CartTab()) {
            screen(name = NavigationTree.Tab.name) {
                TabScreen(it as? Int)
            }
        }
    }
}
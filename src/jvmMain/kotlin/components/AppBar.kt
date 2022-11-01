package components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppBar(modifire: Modifier){
    TopAppBar(
        //https://github.com/JetBrains/compose-jb/tree/master/tutorials/Navigation
        modifier = modifire,
        title = {
            Text("Top app bar")
        }
    )
}
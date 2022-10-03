package isel.pt.androidbattleship.visual

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import isel.pt.androidbattleship.ui.theme.AndroidBattleshipTheme
import isel.pt.androidbattleship.R
@Composable
fun GameRealizationScreen() {
    AndroidBattleshipTheme {

        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.green)
        ) {
            Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()){
                CreateGrid(text = "Enemy grid", R.color.red)
                CreateGrid(text = "Your grid", R.color.ocean_blue)
            }


        }
    }
}


@Composable
fun CreateGrid(text: String, color: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text )
    }

    Box(
        modifier = Modifier
            .padding(horizontal = 50.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Surface(

            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            color = colorResource(id = color)
        ) {

        }
    }
}

@Preview
@Composable
fun Grid() {
    GameRealizationScreen()
}
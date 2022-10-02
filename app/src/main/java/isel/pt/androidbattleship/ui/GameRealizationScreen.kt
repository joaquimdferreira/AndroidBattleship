package isel.pt.androidbattleship.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import isel.pt.androidbattleship.ui.theme.AndroidBattleshipTheme

@Composable
fun GameRealizationScreen() {
    AndroidBattleshipTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = SteelBlue
        ) {
            Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()){
                CreateGrid(text = "enemy grid", 1.0F, NotBlue)
                CreateGrid(text = "your grid", 2.0F, OceanBlue)
            }


        }
    }
}

@Stable
val OceanBlue = Color(0xff0197f6)

@Stable
val NotBlue = Color(0xffff97f6)

@Stable
val SteelBlue = Color(0xff51DF18)

@Composable
fun CreateGrid(text: String, weight: Float, color: Color) {
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
            color = color
        ) {

        }
    }
}

@Preview
@Composable
fun Grid() {
    GameRealizationScreen()
}
package isel.pt.androidbattleship.visual

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import isel.pt.androidbattleship.ui.theme.AndroidBattleshipTheme
import isel.pt.androidbattleship.R
import isel.pt.androidbattleship.domain.board.BOARD_SIZE

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
                CreateGrid(text = "Enemy fleet", R.color.red)
                CreateGrid(text = "Your fleet", R.color.ocean_blue)
            }


        }
    }
}


@Composable
fun CreateGrid(text: String, color: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, fontSize = 30.sp, fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold )
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

@Composable
fun Square(isDarkSquare: Boolean) {
    val purple = colorResource(id = R.color.purple_200)
    val purple2 = colorResource(id = R.color.purple_500)
    Canvas(modifier = Modifier.fillMaxSize(1f)) {
        drawRect(color = if (isDarkSquare)  purple
        else purple2)
    }
}


@Composable
fun Board() {
    Box(
        Modifier
            .fillMaxSize()
            .aspectRatio(1f)) {
        Column {
            for (rank in 0 until BOARD_SIZE) {
                Row(modifier = Modifier.weight(1f)) {

                    Square(
                        rank%2 == 0/* other params */
                    )

                }

            }
        }
    }
}


@Preview
@Composable
fun BoardPreview() {
    GameRealizationScreen()
}

@Preview
@Composable
fun GridPreview() {
    Board()
}
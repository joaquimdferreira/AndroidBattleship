package isel.pt.androidbattleship.visual

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import kotlin.random.Random

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CreateGrid(text: String, color: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        val numbers = (0 until BOARD_SIZE * BOARD_SIZE).toList()

        LazyVerticalGrid(
            cells = GridCells.Fixed(BOARD_SIZE),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(numbers.size) { item ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .clip(RectangleShape)
                            .background(if(item % 2 == 0) Color.Red else Color.Blue)
                            .padding(18.dp)
                    )
                }
            }
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

/*
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Board() {
    Box(
        Modifier
            .fillMaxSize()
            .aspectRatio(1f)
    ) {
        val numbers = (0 until BOARD_SIZE* BOARD_SIZE).toList()

        LazyVerticalGrid(
            cells = GridCells.Fixed(BOARD_SIZE),
            contentPadding = PaddingValues(14.dp)
        ) {
            items(numbers.size) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Card(
                        modifier = Modifier
                            .padding(18.dp),
                        backgroundColor = colorResource(id = R.color.ocean_blue)
                    ) {
                        Surface(
                            modifier = Modifier
                            .fillMaxSize(),
                            color = colorResource(id = R.color.ocean_blue)) {
                        }
                    }
                }
            }
        }
    }
}
*/

@Preview
@Composable
fun BoardPreview() {
    GameRealizationScreen()
}
/*
@Preview
@Composable
fun GridPreview() {
    Board()
}

 */
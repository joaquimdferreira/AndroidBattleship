package isel.pt.androidbattleship.visual

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import isel.pt.androidbattleship.R
import isel.pt.androidbattleship.ui.theme.AndroidBattleshipTheme

@Composable
fun GameMeuScreen() {
    AndroidBattleshipTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.ocean_blue)
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally


            ) {
                Text(text = "BattleShips", fontSize = 50.sp)
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Text(text = "  MENU  ", fontSize = 25.sp, color = Color(0xFFFFFFFF), modifier = Modifier.background(color= colorResource(id = R.color.teal_200)))
                Spacer(modifier = Modifier.padding(vertical = 110.dp))
                Text(text = "       JOIN       ", fontSize = 40.sp, color = Color(0xFFFFFFFF), modifier = Modifier.background(color= colorResource(id = R.color.purple_200)))
                Spacer(modifier = Modifier.padding(vertical = 20.dp))
                Text(text = "  SAVED GAMES  ", fontSize = 30.sp, color = Color(0xFFFFFFFF), modifier = Modifier.background(color= colorResource(id = R.color.purple_200)))
                Spacer(modifier = Modifier.padding(vertical = 70.dp))
                Text(text = "  CREDITS  ", fontSize = 20.sp, color = Color(0xFFFFFFFF), modifier = Modifier.background(color= colorResource(id = R.color.purple_200)))

            }

        }
    }
}

@Preview
@Composable
fun Menu() {
    GameMeuScreen()
}
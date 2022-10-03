package isel.pt.androidbattleship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import isel.pt.androidbattleship.visual.GameRealizationScreen
import isel.pt.androidbattleship.visual.GameRealizationViewModel

class MainActivity : ComponentActivity() {
    private val vm by viewModels<GameRealizationViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return GameRealizationViewModel() as T
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameRealizationScreen()
        }
    }
}

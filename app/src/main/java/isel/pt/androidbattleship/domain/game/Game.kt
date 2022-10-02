package isel.pt.androidbattleship.domain

interface Game {
    val gameState: GameState
}

enum class GameState {
    Starting,
    Running,
    Ended
}
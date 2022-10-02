package isel.pt.androidbattleship.domain.game

import isel.pt.androidbattleship.domain.Game
import isel.pt.androidbattleship.domain.GameState
import isel.pt.androidbattleship.domain.board.Board
import isel.pt.androidbattleship.domain.board.model.Player

class StartingGame(player: Player, board: Board = Board(player)): Game {
    override val gameState = GameState.Starting
    fun startGame(): RunningGame {
        TODO()
    }
}
package isel.pt.androidbattleship.domain.game

import isel.pt.androidbattleship.domain.Game
import isel.pt.androidbattleship.domain.GameState
import isel.pt.androidbattleship.domain.board.Board
import isel.pt.androidbattleship.domain.board.model.Player

class FinishedGame(
    player1: Player, p1Board: Board,
    player2: Player, p2Board: Board,
    val winner: Player
    ): Game {
    override val gameState = GameState.Ended

}
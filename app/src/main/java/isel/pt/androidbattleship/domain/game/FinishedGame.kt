package isel.pt.androidbattleship.domain.game

import isel.pt.androidbattleship.domain.Game
import isel.pt.androidbattleship.domain.GameState
import isel.pt.androidbattleship.domain.board.Board
import isel.pt.androidbattleship.domain.board.model.Player

class FinishedGame(
    private val p1: Player,private val p1Board: Board,
    private val p2: Player,private val p2Board: Board,
    val winner: Player,private val currTurn: Player = winner
    ): Game {
    override val gameState = GameState.Ended


}
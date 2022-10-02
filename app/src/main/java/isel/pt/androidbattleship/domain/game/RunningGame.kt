package isel.pt.androidbattleship.domain.game

import isel.pt.androidbattleship.domain.Game
import isel.pt.androidbattleship.domain.GameState
import isel.pt.androidbattleship.domain.board.Board
import isel.pt.androidbattleship.domain.board.model.Player

class RunningGame(
    private val player1: Player, private val p1Board: Board,
    private val player2: Player, private val p2Board: Board,
    private val currTurn: Player
    ): Game {

    override val gameState = GameState.Running


}


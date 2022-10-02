package isel.pt.androidbattleship.domain.board

import isel.pt.androidbattleship.domain.board.coord.Position
import isel.pt.androidbattleship.domain.board.coord.toPositionOrNull
import isel.pt.androidbattleship.domain.board.model.Player

const val BOARD_SIZE = 10

data class Move(val player: Player, val position: Position)

class Board(private val player: Player) {
    private val moveList = mutableListOf<Move>()

    fun play(playMaker: Player, position: String) {
        require(playMaker.other() != player) {"This player cannot perform this action."}
        val pos = position.toPositionOrNull()
        require(pos != null) {"An invalid position has been selected."}
        val move = Move(playMaker, pos)
        require(move !in moveList)

        //calculate move outcome -> ()

        moveList.add(move)
    }


}


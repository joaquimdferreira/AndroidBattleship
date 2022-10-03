package isel.pt.androidbattleship.domain.board

import isel.pt.androidbattleship.domain.board.coord.Position
import isel.pt.androidbattleship.domain.board.model.Player
import isel.pt.androidbattleship.domain.board.model.ShipType

const val BOARD_SIZE = 10

data class Move(val player: Player, val position: Position)
data class ShipPos(val ship: ShipType, val posList: List<Position>) {
    init {
        require( posList.size == ship.squares)
    }
}

enum class Arrangement {Vertical, Horizontal}

class Board(
    private val player: Player,
    private val moveList: List<Move> = mutableListOf(),
    private val positions: Map<String, Position> = Position.values,
    private val shipPositions:  List<ShipPos> = mutableListOf()
) {
    fun putShip(ship: ShipType, initPos: Position, arrangement: Arrangement): Board {
        //generate pos for ships
        val posList = mutableListOf<Position>()
        if(checkAvailability())

    }

    private fun checkAvailability(size: Int, pos: Position): Boolean {

    }

    fun play(playMaker: Player, position: Position): Board {
        require(playMaker != player) {"This player cannot perform this action."}
        val move = Move(playMaker, position)
        require(move !in moveList)

        //calculate move outcome -> ()

        return Board(player, moveList + move)
    }

    fun calculateMove() {

    }

    fun getLastMove() = moveList.last()

    fun reverseOne(): Board {
        if(moveList.isNotEmpty())return Board(player, moveList - moveList.last())
        else throw IllegalStateException("Board is already at the beginning")
    }
}


package isel.pt.androidbattleship.domain.board

import isel.pt.androidbattleship.domain.board.coord.Position
import isel.pt.androidbattleship.domain.board.model.Player
import isel.pt.androidbattleship.domain.board.model.ShipType
import isel.pt.androidbattleship.domain.board.model.totalShips

const val BOARD_SIZE = 10

sealed class Board(
    val moveList: List<Move> = listOf(),
    val shipPosList: List<List<Position>> = listOf()
) {
    abstract fun play(player: Player, pos: Position): Board
}
/*
class BoardStarting(moveList: List<Move> = listOf(), shipPosList: List<List<Position>> = listOf()): Board(moveList, shipPosList) {
    override fun play(player: Player, pos: Position): Board {
        throw IllegalStateException("This game hasn't started yet.")
    }

    fun putShip(ship: ShipType, initPos: Position, arrangement: Arrangement): Board {
        val posList: List<Position> = mutableListOf()
        val initCol = initPos.column.index
        val initRow = initPos.row.index
        for(i in 0 until ship.squares){
            //check arrangement
            val pos = Position(initCol+i, initRow+i) ?: throw IllegalStateException("Ship cannot fit in selected position")
            if(canPutShip(pos))posList += pos
            else throw IllegalStateException("Ship cannot fit in selected position")
        }
        //change here
        val newPosList: List<List<Position>> =
        if(newPosList.size == totalShips)BoardRun(shipPosList = newPosList)
        return BoardRun()
    }

    private fun canPutShip(pos: Position) = shipPosList.find { it == pos } == null
}

class BoardRun(
    private val player: Player,
    moveList: List<Move> = mutableListOf(),
    shipPosList: List<List<Position>>
): Board(moveList, shipPosList) {
    override fun play(player: Player, pos: Position): Board {
        require(player == this.player) {"This player cannot perform this action."}
        val move = Move(player, pos)
        require(move !in moveList)

        //calculate move outcome -> ()

        return BoardRun(player = player, moveList = moveList + move, shipPosList = shipPosList)
    }

    fun calculateMove() {

    }

    fun getLastMove() = moveList.last()

    fun reverseOne(): Board {
        if(moveList.isNotEmpty())return BoardRun(player, moveList - moveList.last(), shipPositions)
        else throw IllegalStateException("Board is already at the beginning")
    }
}

 */


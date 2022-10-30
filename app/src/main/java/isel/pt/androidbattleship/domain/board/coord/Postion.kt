package isel.pt.androidbattleship.domain.board.coord

import isel.pt.androidbattleship.domain.board.BOARD_SIZE

fun String.toPositionOrNull(): Position? {
    val cordPair = parseString(this) ?: return null
    val row = cordPair.first.toRowOrNull()
    val column = cordPair.second.toColumnOrNull()
    return Position.getPosition(row, column)
}

fun String.toSquare(): Position = this.toPositionOrNull() ?: throw IllegalArgumentException()

private fun parseString(str: String): Pair<Int,Char>? {
    if(str.isEmpty())return null
    val second = str.last()
    val first = str.dropLast(1).toIntOrNull() ?: return null
    return Pair(first, second)
}

class Position(val column: Column, val row: Row){
    companion object {
        operator fun invoke(rowIdx: Int, columnIdx: Int) =
            getPosition(rowIdx.indexToRowOrNull(), columnIdx.indexToColumnOrNull())

        operator fun invoke(row: Row, column: Column) =
            getPosition(row, column) ?: throw IllegalStateException("No such square exists in values")

        val values : ArrayList<Position> = initSquares()

        private fun initSquares(): java.util.ArrayList<Position> {
            val list = ArrayList<Position>(BOARD_SIZE * BOARD_SIZE)
            repeat(BOARD_SIZE) { rIdx ->
                repeat(BOARD_SIZE) { cIdx ->
                    list.add(Position(rIdx.indexToRow(), cIdx.indexToColumn()))
                }
            }
            return list
        }

        fun getPosition(row: Row?, column: Column?): Position? {
            return values.find { it.row == row && it.column == column }
        }
    }

    override fun toString(): String {
        return "${this.row.number}${this.column.symbol}"
    }
}
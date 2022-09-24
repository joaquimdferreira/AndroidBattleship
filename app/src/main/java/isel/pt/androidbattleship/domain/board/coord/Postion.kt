package isel.pt.androidbattleship.domain.board.coord
fun String.toPositionOrNull(): Position? {
    val pair = parseString(this) ?: return null

    val letter: Char = pair.first
    val number: Int = pair.second

    val column = letter.toColumnOrNull()
    val row = number.toRowOrNull()

    return if(column == null || row == null) null
    else Position.get(column = column, row = row)
}

fun String.toPosition(): Position = this.toPositionOrNull() ?: throw IllegalStateException("No such Position found")

private fun parseString(string: String): Pair<Char, Int>?{
    val letter: Char
    val number: Int
    when (string.length) {
        3 -> {
            letter = string.first()
            number = string.takeLast(2).toInt()
        }
        2 -> {
            letter = string.first()
            number = string.last().code - '0'.code
        }
        else -> return null
    }
    return Pair(letter, number)
}

class Position(val column: Column, val row: Row){

    override fun toString():String = "${column.letter}${row.number}"

    companion object {

        val values = initPositions()

        private fun initPositions():Map<String, Position>{
            val map=mutableMapOf<String, Position>()
            val columns = Column.values
            val rows = Row.values
            for(i in columns.indices){
                for(j in rows.indices){
                    val pos= Position(columns[i],rows[j])
                    map[pos.toString()] = pos
                }
            }
            return map
        }


        operator fun get(indexColumn:Int, indexRow:Int): Position {
            val column= indexColumn.indexToColumn()
            val row= indexRow.indexToRow()
            return values.getValue(Position(column,row).toString())
        }

        operator fun get(column: Column, row: Row): Position = values.getValue(Position(column,row).toString())

    }
}
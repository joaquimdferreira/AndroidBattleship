package isel.pt.androidbattleship.domain.board.coord

import isel.pt.androidbattleship.domain.board.BOARD_SIZE

const val COLUMN_DIM = BOARD_SIZE

fun Char.toColumnOrNull(): Column? = Column.getColumn(symbol = this)
fun Int.indexToColumnOrNull(): Column? = Column.getColumn(index = this)
fun Int.indexToColumn(): Column = this.indexToColumnOrNull() ?: throw IndexOutOfBoundsException()

class Column private constructor(val symbol: Char, val index: Int){
    companion object{
        operator fun invoke(symbol: Char, index: Int? = null) = getColumn(symbol, index)

        val values : ArrayList<Column> = initColumns()

        private fun initColumns (): ArrayList<Column> {
            val list = ArrayList<Column>(BOARD_SIZE)
            var initS = 'a'
            repeat(BOARD_SIZE) {
                list.add(Column(initS, it))
                initS = initS.inc()
            }
            return list
        }
        fun getColumn(symbol: Char? = null, index: Int? = null): Column? {
            return if (symbol != null) values.find { it.symbol == symbol }
            else if (index != null) values.find { it.index == index }
            else throw IllegalArgumentException()
        }
    }
}
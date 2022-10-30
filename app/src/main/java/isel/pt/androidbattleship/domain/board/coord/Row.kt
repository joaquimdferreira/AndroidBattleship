package isel.pt.androidbattleship.domain.board.coord

import isel.pt.androidbattleship.domain.board.BOARD_SIZE

const val ROW_DIM = BOARD_SIZE

fun Int.toRowOrNull(): Row? = Row.getRow(number = this)
fun Int.indexToRow(): Row = this.indexToRowOrNull() ?: throw IndexOutOfBoundsException()

fun Int.indexToRowOrNull(): Row? = Row.getRow(index = this)
class Row private constructor(val number: Int, val index: Int) {
    companion object {
        operator fun invoke(number: Int) = getRow(number)

        val values : ArrayList<Row> = initRows()

        private fun initRows(): ArrayList<Row> {
            val list = ArrayList<Row>(BOARD_SIZE)
            repeat(BOARD_SIZE) {
                list.add(Row(BOARD_SIZE - it, it))
            }
            return list
        }
        fun getRow(number: Int? = null, index: Int? = null): Row? {
            return if (number != null) values.find { it.number == number }
            else if (index != null) values.find { it.index == index }
            else throw IllegalArgumentException()
        }
    }
}
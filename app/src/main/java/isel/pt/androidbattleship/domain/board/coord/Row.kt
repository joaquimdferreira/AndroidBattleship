package isel.pt.androidbattleship.domain.board.coord

const val ROW_DIM = 10

fun Int.toRowOrNull(): Row? = Row.getRow(number = this, rowList = Row.values)
fun Int.indexToRowOrNull(): Row? = Row.getRow(ordinal = this, rowList = Row.values)
fun Int.indexToRow(): Row = Row.getRow(ordinal = this, rowList = Row.values) ?: throw IndexOutOfBoundsException()

class Row(val number: Int, val ordinal: Int){
    companion object {
        val values: ArrayList<Row> = initRows()

        private fun initRows(): ArrayList<Row> {
            val rows = arrayListOf<Row>()
            for (i in 0 until ROW_DIM) {
                val r = Row(i + 1, i)
                rows.add(r)
            }
            return rows
        }

        fun getRow(number: Int? = null, ordinal: Int? = null, rowList: ArrayList<Row>): Row? {
            return if(number != null) getRowByNumber(number, rowList)
            else if(ordinal != null) getColumnByOrdinal(ordinal, rowList)
            else null
        }

        private fun getRowByNumber(number: Int, rowList: ArrayList<Row>): Row? {
            var row: Row
            for( i in rowList.indices){
                row = rowList[i]
                if(row.number == number)return row
            }
            return null
        }

        private fun getColumnByOrdinal(ordinal: Int, rowList: ArrayList<Row>): Row? {
            var row: Row
            for( i in rowList.indices){
                row = rowList[i]
                if(row.ordinal == ordinal)return row
            }
            return null
        }

    }
}
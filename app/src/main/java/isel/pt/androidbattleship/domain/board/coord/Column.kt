package isel.pt.androidbattleship.domain.board.coord

const val COLUMN_DIM = 10

fun Char.toColumnOrNull(): Column? = Column.getColumn(letter = this.uppercaseChar(), columnList = Column.values)
fun Int.indexToColumnOrNull(): Column? = Column.getColumn(ordinal = this, columnList = Column.values)
fun Int.indexToColumn(): Column = Column.getColumn(ordinal = this, columnList = Column.values) ?: throw IndexOutOfBoundsException()

class Column(val letter: Char, val ordinal: Int){
    companion object{
        val values:ArrayList<Column> = initColumns()

        private fun initColumns() : ArrayList<Column> {
            val columns = arrayListOf<Column>()
            var columnLetter = 'A'
            for( i in 0 until COLUMN_DIM){
                val c = Column(columnLetter, i)
                columns.add(c)
                columnLetter = columnLetter.inc()
            }
            return columns
        }

        fun getColumn(letter: Char? = null, ordinal: Int? = null, columnList: ArrayList<Column>): Column? {
            return if(letter != null) getColumnByLetter(letter, columnList)
            else if(ordinal != null) getColumnByOrdinal(ordinal, columnList)
            else null
        }

        private fun getColumnByLetter(letter: Char, columnList: ArrayList<Column>): Column? {
            var column: Column
            for( i in columnList.indices){
                column = columnList[i]
                if(column.letter == letter)return column
            }
            return null
        }

        private fun getColumnByOrdinal(ordinal: Int, columnList: ArrayList<Column>): Column? {
            var column: Column
            for( i in columnList.indices){
                column = columnList[i]
                if(column.ordinal == ordinal)return column
            }
            return null
        }

    }
}
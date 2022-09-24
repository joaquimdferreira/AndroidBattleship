package isel.pt.androidbattleship

import isel.pt.androidbattleship.domain.board.coord.*
import org.junit.Assert
import org.junit.Test
//1234567
class ColumnTest {
    @Test
    fun `number of columns`() {
        Assert.assertEquals(10, COLUMN_DIM)
        Assert.assertEquals(COLUMN_DIM, Column.values.size)
    }
    @Test
    fun `letter of each column`() {
        Assert.assertEquals('A', Column.values.first().letter)
        Assert.assertEquals('J', Column.values.last().letter)
        Assert.assertEquals("ABCDEFGHIJ".toList(), Column.values.map { it.letter })
    }
    @Test
    fun `ordinal of column`() {
        Assert.assertEquals(0, Column.values.first().ordinal)
        Assert.assertEquals(COLUMN_DIM - 1, Column.values.last().ordinal)
        Assert.assertEquals((0 until COLUMN_DIM).toList(), Column.values.map { it.ordinal })
    }
    @Test
    fun `column from letter`() {
        Assert.assertSame('A'.toColumnOrNull(), Column.values[0])
        Assert.assertSame('j'.toColumnOrNull(), Column.values[COLUMN_DIM - 1])
        Assert.assertEquals(null, 'X'.toColumnOrNull())
    }
    @Test
    fun `column from index`() {
        Assert.assertSame(3.indexToColumnOrNull(), Column.values[3])
        Assert.assertSame(5.indexToColumn(), Column.values[5])
        Assert.assertEquals(null, 34.indexToColumnOrNull())
        Assert.assertEquals(null, (-3).indexToColumnOrNull())
    }
}
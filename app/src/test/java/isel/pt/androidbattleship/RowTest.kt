package isel.pt.androidbattleship

import isel.pt.androidbattleship.domain.board.coord.*
import org.junit.Assert
import org.junit.Test

class RowTest {
    @Test
    fun `number of rows`() {
        Assert.assertEquals(10, ROW_DIM)
        Assert.assertEquals(ROW_DIM, Row.values.size)
    }
    @Test
    fun `number of each row`() {
        Assert.assertEquals(1, Row.values.first().number)
        Assert.assertEquals(10, Row.values.last().number)
        Assert.assertEquals((1..ROW_DIM).toList(), Row.values.map { it.number })
    }
    @Test
    fun `ordinal of rows`() {
        Assert.assertEquals(0, Row.values.first().ordinal)
        Assert.assertEquals(ROW_DIM - 1, Row.values.last().ordinal)
        Assert.assertEquals((0 until ROW_DIM).toList(), Row.values.map { it.ordinal })
    }
    @Test
    fun `row from number`() {
        Assert.assertSame(1.toRowOrNull(), Row.values[0])
        Assert.assertSame(10.toRowOrNull(), Row.values[ROW_DIM - 1])
        Assert.assertEquals(null, 'X'.toColumnOrNull())
    }
    @Test
    fun `row from index`() {
        Assert.assertSame(3.indexToRowOrNull(), Row.values[3])
        Assert.assertSame(5.indexToRow(), Row.values[5])
        Assert.assertEquals(null, 34.indexToRowOrNull())
        Assert.assertEquals(null, (-3).indexToRowOrNull())
    }
}
package isel.pt.androidbattleship

import isel.pt.androidbattleship.domain.board.coord.*
import org.junit.Assert
import org.junit.Test

class PositionTest {
    @Test
    fun `Get position by index`() {
        val sut = Position.get(indexColumn = 2, indexRow = 3)
        Assert.assertEquals('C', sut.column.letter)
        Assert.assertEquals(4, sut.row.number)
        Assert.assertEquals("C4", sut.toString())
    }
    @Test
    fun `Get position by Column and Row`() {
        val sut = Position.get(2.indexToColumn(),3.indexToRow())
        Assert.assertEquals("C4", sut.toString())
    }
    @Test
    fun `Get position using index operators`() {
        val p1 = Position[2,3]
        val p2 = Position[2.indexToColumn(),3.indexToRow()]
        Assert.assertEquals(p1.toString(), p2.toString())
        Assert.assertSame(p1, p2) // Identity
    }
    @Test
    fun `Position from String`() {
        val sut = "J10".toPositionOrNull()
        Assert.assertNotNull(sut)
        Assert.assertEquals("J10", sut.toString())
        Assert.assertEquals(null, "X3".toPositionOrNull())
        Assert.assertNotNull("A1".toPositionOrNull())
        Assert.assertSame(Position[0, 0], "A1".toPosition())
    }
}
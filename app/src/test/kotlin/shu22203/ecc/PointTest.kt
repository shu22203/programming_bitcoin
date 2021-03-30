package shu22203.ecc

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class PointTest {
    @Test
    fun testEqual() {
        val p1 = Point(-1, -1, 5, 7)
        val p2 = Point(-1, 1, 5, 7)
        assertEquals(p1, p1)
        assertNotEquals(p1, p2)
    }

    @Test
    fun testPlus() {
        val p1 = Point(-1, -1, 5, 7)
        val p2 = Point(-1, 1, 5, 7)
        val p3 = Point(2, 5, 5, 7)
        val inf = Point(null, null, 5, 7)
        assertEquals(p1 + inf, p1) // A + I
        assertEquals(inf + p2, p2) // I + A
        assertEquals(p1 + p2, inf) // A + -(A) = I
        assertEquals(p1 + p3, Point(3, -7, 5, 7)) // P1 != P2
        assertEquals(p1 + p1, Point(18, 77, 5, 7)) // P1 = P2
    }
}

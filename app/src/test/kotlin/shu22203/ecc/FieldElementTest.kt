package shu22203.ecc

import kotlin.test.Test
import kotlin.test.assertNotEquals
import kotlin.test.assertEquals

class FieldElementTest {
    @Test
    fun testEqual() {
        val a = FieldElement(7, 13)
        val b = FieldElement(12, 13)
        assertNotEquals(a, b)
        assertEquals(a, a)
    }

    @Test
    fun testPlus() {
        val a = FieldElement(7, 13)
        val b = FieldElement(12, 13)
        val c = FieldElement(6, 13)
        assertEquals(a + b, c)
    }

    @Test
    fun testTimes() {
        val a = FieldElement(3, 13)
        val b = FieldElement(12, 13)
        val c = FieldElement(10, 13)
        assertEquals(a * b, c)
    }

    @Test
    fun testPow() {
        val a = FieldElement(3, 13)
        val b = FieldElement(1, 13)
        val c = FieldElement(7, 13)
        val d = FieldElement(8, 13)
        assertEquals(a.pow(3), b)
        assertEquals(a.pow(4), a)
        assertEquals(c.pow(-3), d)
    }

    @Test
    fun testDiv() {
        val a = FieldElement(2, 19)
        val b = FieldElement(7, 19)
        val c = FieldElement(3, 19)
        val d = FieldElement(5, 19)
        val e = FieldElement(9, 19)
        assertEquals(a / b, c)
        assertEquals(b / d, e)
    }
}

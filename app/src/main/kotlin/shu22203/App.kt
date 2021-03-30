package shu22203

import shu22203.ecc.FieldElement
import shu22203.ecc.Point

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main() {
    println(App().greeting)
    val a = FieldElement(7, 13)
    val b = FieldElement(12, 13)
    val c = FieldElement(6, 13)
    val p1 = Point(2, 5, 5, 7)
    val p2 = Point(-1, -1, 5, 7)
    println(p1 + p2)
    println(p2 + p2)
}

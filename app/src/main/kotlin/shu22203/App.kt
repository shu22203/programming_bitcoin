package shu22203

import shu22203.ecc.FieldElement

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
    println(a+b==c)
}

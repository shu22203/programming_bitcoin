package shu22203.ecc

class FieldElement(val num: Int, val prime: Int) {
    init {
        if (num >= prime || num < 0) {
            throw Exception("Num %d not in field range 0 to %d".format(num, prime - 1))
        }
    }

    override operator fun equals(other: Any?): Boolean {
        if (other !is FieldElement) {
            return false
        }
        return num == other.num && prime == other.prime
    }

    operator fun plus(other: FieldElement): FieldElement {
        if (prime != other.prime) {
            throw Exception("Cannot add two numbers in different Fields")
        }
        val ret = (num + other.num) % prime
        return FieldElement(ret, prime)
    }

    operator fun times(other: FieldElement): FieldElement {
        if (prime != other.prime) {
            throw Exception("Cannot add two numbers in different Fields")
        }
        val ret = (num * other.num) % prime
        return FieldElement(ret, prime)
    }

    fun pow(exponent: Int): FieldElement {
        var n = exponent
        while (n < 0) {
            n += prime - 1
        }
        val ret = (Math.pow(num.toDouble(), n.toDouble())) % prime
        return FieldElement(ret.toInt(), prime)
    }

    operator fun div(other: FieldElement): FieldElement {
        if (other !is FieldElement) {
            throw Exception("Type mismatched")
        }
        if (prime != other.prime) {
            throw Exception("Cannot add two numbers in different Fields")
        }
        return this * other.pow(prime - 2)
    }
}

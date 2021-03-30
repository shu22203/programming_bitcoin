package shu22203.ecc

class Point(val x: Int?, val y: Int?, val a: Int, val b: Int) {
    init {
        if (x == null || y == null) {
        } else if (Math.pow(y.toDouble(), 2.0) != Math.pow(x.toDouble(), 3.0) + a * x + b) {
            throw Exception("%s %s is not on the curve".format(x, y))
        }
    }

    override operator fun equals(other: Any?): Boolean {
        if (other !is Point) {
            return false
        }
        return x == other.x && y == other.y && a == other.a && b == other.b
    }

    operator fun plus(other: Point): Point {
        if (a != other.a || b != other.b) {
            throw Exception("Points %s, %s are not on the same curve".format(this, other))
        }

        // I + A = A
        if (x == null || y == null) {
            return other
        }

        // A + I = A
        if (other.x == null || other.y == null) {
            return this
        }

        // A + (-A) = I
        if (x == other.x && y != other.y) {
            return Point(null, null, a, b)
        }

        // P1 != P2
        if (x != other.x && y != other.y) {
            val s = (other.y - y) / (other.x - x)
            val x3 = Math.pow(s.toDouble(), 2.0) - x - other.x
            val y3 = s * (x - x3) - y
            return Point(x3.toInt(), y3.toInt(), a, b)
        }

        // P1 = P2 (接線)
        if (x == other.x && y == other.y && y != 0) {
            var s = (3 * Math.pow(x.toDouble(), 2.0) + a) / 2 * y
            var x3 = Math.pow(s.toDouble(), 2.0) - 2 * x
            var y3 = s * (x - x3) - y
            return Point(x3.toInt(), y3.toInt(), a, b)
        }

        // 接線が垂直線
        if (this == other && y == 0) {
            return Point(null, null, a, b)
        }
        return this
    }

    override fun toString(): String {
        return "Point(%d,%d)_%d_%d".format(x, y, a, b)
    }
}

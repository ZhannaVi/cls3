import kotlin.math.sqrt

data class Point(val x: Double, val y: Double) {
    fun distanceTo(other: Point): Double {
        val dx = x - other.x
        val dy = y - other.y
        return sqrt(dx * dx + dy * dy)
    }
}

fun main() {
    print("Введите количество точек: ")
    val count = readLine()?.toIntOrNull() ?: throw Exception("Некорректное число")

    if (count <= 2) {
        throw Exception("Количество точек должно быть больше 2")
    }

    val points = mutableListOf<Point>()

    for (i in 1..count) {
        print("Введите координаты точки $i (через пробел): ")
        val input = readLine()?.split(" ") ?: throw Exception("Некорректные координаты")
        val x = input.getOrNull(0)?.toDoubleOrNull() ?: throw Exception("Некорректная координата x")
        val y = input.getOrNull(1)?.toDoubleOrNull() ?: throw Exception("Некорректная координата y")
        val point = Point(x, y)
        points.add(point)
    }

    var minDistance = Double.MAX_VALUE
    var maxDistance = Double.MIN_VALUE

    for (i in 0 until count - 1) {
        for (j in i + 1 until count) {
            val distance = points[i].distanceTo(points[j])
            minDistance = minOf(minDistance, distance)
            maxDistance = maxOf(maxDistance, distance)
        }
    }

    println("Минимальное расстояние: $minDistance")
    println("Максимальное расстояние: $maxDistance")
}
package aquarium.decorations

fun main() {
    makeDecorations()
}

fun makeDecorations() {
    val d1 = Decorations("granite")
    println(d1)

    val d2 = Decorations("slate")
    println(d2)

    val d3 = Decorations("slate")
    println(d3)

    println(d1.equals(d2))
    println(d3.equals(d2))

    val d4: Decorations = d3.copy()
    println(d3)
    println(d4)

    val d5 = Decorations2("crystal", "wood", "diver")
    println(d5)

}

data class Decorations(val rocks: String) {}

data class Decorations2(val rocks: String, val wood: String, val diver: String) {}
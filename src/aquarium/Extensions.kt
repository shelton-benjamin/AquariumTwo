package aquarium

fun String.hasSpaces() = find {it == ' '} != null

fun extensionsExample() {
    "Does it have spaces?".hasSpaces()
}

open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int): AquariumPlant("Green", size)

fun AquariumPlant.isRed() = color == "Red"

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print()

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()
}

val AquariumPlant.isGreen: Boolean
get() = color == "Green"

fun propertyExample() {
    val plant = AquariumPlant("Green", 50)
    plant.isGreen
}

fun AquariumPlant?.pull() {

    this?.apply { println("removing $this") }
}

fun nullableExample() {
    val plant: AquariumPlant? = null
    plant.pull()
}
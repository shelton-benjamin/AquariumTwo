package buildings

fun main() {

    Building(Wood()).build()
    isSmallBuilding(Building(Brick()))
}

open class BaseBuildingMaterial() {

    open val numberNeeded = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded: Int
        get() = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded: Int
        get() = 8
}

class Building<out T : BaseBuildingMaterial>(val buildingMaterial: T) {
    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println(" $actualMaterialsNeeded ${buildingMaterial::class.simpleName} required")
    }
}

fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("Small building")
    else println("large building")
}

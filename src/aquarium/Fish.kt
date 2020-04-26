package aquarium

class Fish(val friendly : Boolean = true, volumeNeeded: Int) {

    val size: Int

    init{
        println("first init block")
    }

    constructor() : this(true, 9) {
        println("running secondary constructor")
    }

    init {
        size = if (friendly) {
            volumeNeeded
        } else {
            volumeNeeded * 2
        }
    }

    init {
        println("constructed fish of size $volumeNeeded final size ${this.size}")
    }

    init{
        println("last init block")
    }
}

fun makeDefaultFish() = Fish(true, 50)

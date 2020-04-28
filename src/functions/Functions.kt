package functions

fun main() {

    val game = Game()
//    println(game.path)
//    game.north()
//    game.east()
//    game.south()
//    game.west()
//    game.end()
//    println(game.path)

    while (true) {
        print("Enter a direction: n/s/e/w: ")
        game.makeMove(readLine())
    }

}

enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game() {


    val path: MutableList<Direction> = mutableListOf(Direction.START)
    val north = { path.add(Direction.NORTH) }
    val south = { path.add(Direction.SOUTH) }
    val east = { path.add(Direction.EAST) }
    val west = { path.add(Direction.WEST) }
    val end = { path.add(Direction.END); println("Game Over: $path"); path.clear(); false }

    fun move(where: () -> Boolean) {
        where.invoke()
    }

    fun makeMove(command: String?) {
       when (command) {
           "n" -> move (north)
           "s" ->  move(south)
           "e" ->  move(east)
           "w" ->  move(west)
           else -> move(end)
       }
    }
}



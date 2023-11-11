import java.io.File
fun getLevel(path: String = "src/main/resources/level.txt"): MutableList<String> {
    val fileLines: List<String> = File(path).readLines()
    val board: MutableList<String> = mutableListOf()
    fileLines.forEach{
        board.add(it)
    }
    return board
}

val board: MutableList<String> = getLevel()
fun main() {
    val game = Game(board)
    game.renderBoard()
    println("Your input: ")
    var input = readln()
    while (input.isNotEmpty()) {
        game.move(input[0])
        if (game.isWon()) {
            println("CONGRATULATIONS, YOU WON!")
            println("Moves: ${game.moveCount}")
            return
        }
        println("Your input: ")
        input = readln()
    }
}
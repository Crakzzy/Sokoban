import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

fun getLevel(path: String = "src/main/resources/level.txt"): MutableList<String> {
    return try {
        val fileLines: List<String> = File(path).readLines()
        fileLines.toMutableList()
    } catch (e: FileNotFoundException) {
        System.err.println("File not found: ${e.message}")
        mutableListOf()
    } catch (e: IOException) {
        System.err.println("Error reading file: ${e.message}")
        mutableListOf()
    }

}

val board: MutableList<String> = getLevel()
fun main() {
    if (board.isEmpty()) {
        return
    }
    val game = Game(board)
    game.renderBoard()
    println("Your input: ")
    var input = readln()
    while (input.isNotEmpty()) {
        game.move(input.first())
        if (game.isWon()) {
            println("CONGRATULATIONS, YOU WON!")
            return
        }
        println("Your input: ")
        input = readln()
    }
}
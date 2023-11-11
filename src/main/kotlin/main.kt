fun welcome() {
    println("Made by Martin Valko (https://github.com/Crakzzy)")
    println("Welcome to Sokoban game!")
    println("Inputs are: ")
    println("W - UP")
    println("A - LEFT")
    println("S - RIGHT")
    println("D - DOWN")
    println("R - RESET LEVEL")
    println("Have fun!")
    println("----------------------------------------------------------------")
}
fun main() {
    welcome()
    val game = Game()
    game.renderBoard()
    println("Your input: ")
    var input = readln()
    while (input.isNotEmpty()) {
        when (input.first()) {
            'r' -> game.resetBoard()
            else -> game.move(input.first())
        }
        if (game.isWon()) {
            println("CONGRATULATIONS, YOU WON!")
            println("Moves: ${game.moveCount}")
            return
        }
        println("Your input: ")
        input = readln()
    }
}
fun main() {
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
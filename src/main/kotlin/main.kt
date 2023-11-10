var board: MutableList<String> =
    mutableListOf (
        "XXXXXX",
        "XXOO X",
        "XXX  X",
        "X B  X",
        "X B XX",
        "XP  XX",
        "XXXXXX",
    )

fun main() {
    val game = Game(board)
    game.renderBoard()
    println("Your input: ")
    var input = readln()
    while (input.isNotEmpty()) {
        game.move(input[0])
        if (game.isWon()) {
            println("CONGRATULATIONS, YOU WON!")
            return
        }
        println("Your input: ")
        input = readln()
    }
}
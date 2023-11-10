var board: MutableList<String> =
    mutableListOf (
        "XXXXXXXXX",
        "XX   XXXX",
        "X O O  XX",
        "X X XX BX",
        "X    BBPX",
        "XXX X  BX",
        "XXX   X X",
        "XXXXXXXXX"
    )

fun main() {
    val game = Game(board)
    game.renderBoard()
    println("Your input: ")
    var input = readln()
    while (input.isNotEmpty()) {
        game.move(input[0])
        println("Your input: ")
        input = readln()
    }
}
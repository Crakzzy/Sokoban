var board: MutableList<String> =
    mutableListOf (
        "XXXXXXXXX",
        "XX   XXXX",
        "X O O   X",
        "X X XX BX",
        "X    BBPX",
        "XXX X   X",
        "XXX   XXX",
        "XXXXXXXXX"
    )

fun main() {
    val game = Game(board)
    game.renderBoard()
    var input = readln()
    while (input.isNotEmpty()) {
        game.move(input[0])
        input = readln()
    }
}
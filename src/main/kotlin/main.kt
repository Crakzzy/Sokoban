var board =
    listOf("XXXXXXXXX", "XX   XXXX", "X O O  XX", "X X XX XX", "X    BB X", "XXX X   X", "XXX   XXX", "XXXXXXXXX")

fun main() {
    val game = Game(board);
    game.renderBoard()

}
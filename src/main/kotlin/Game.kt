class Game(var board: List<String>) {

    var boxes: List<Box> = listOf()

    init {
        for (i in 0..<board.size) {
            for (j in 0..<board[i].length) {
                if (board[i][j] == 'B') {
                    boxes.addLast(Box(i, j))
                }
            }
        }
    }

    fun renderBoard() {
        for (element in board) {
            for (j in 0..<element.length) {
                print(element[j])
            }
            println()
        }
    }
}
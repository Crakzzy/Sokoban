enum class InputType {
    UP, DOWN, LEFT, RIGHT
}

class Game(private var board: MutableList<String>) {
    var moveCount: Int = 0
    private val boxes: MutableList<Box> = mutableListOf()
    private val points: MutableList<Point> = mutableListOf()
    private val player = Player(0, 0)

    init {
        for (i in 0..<board.size) {
            for (j in 0..<board[i].length) {
                if (board[i][j] == 'B') {
                    boxes.add(Box(j, i))
                } else if (board[i][j] == 'B') {
                    boxes.add(Box(j, i))
                } else if (board[i][j] == 'O') {
                    points.add(Point(j, i))
                } else if (board[i][j] == 'P') {
                    player.x = j
                    player.y = i
                }
            }
        }
    }

    fun isWon(): Boolean {
        var counter = 0
        for (str in board) {
            for (char in str) {
                if (char == '✓') {
                    counter++
                }
            }
        }
        return counter == points.size
    }

    fun move(input: Char) {
        when (input) {
            'w' -> {
                if (!player.move(InputType.UP, boxes, board, points)) {
                    System.err.println("Can't move there!")
                }
                moveCount++
            }
            'a' -> {
                if (!player.move(InputType.LEFT, boxes, board, points)) {
                    System.err.println("Can't move there!")
                }
                moveCount++
            }
            's' -> {
                if (!player.move(InputType.DOWN, boxes, board, points)) {
                    System.err.println("Can't move there!")
                }
                moveCount++
            }
            'd' -> {
                if (!player.move(InputType.RIGHT, boxes, board, points)) {
                    System.err.println("Can't move there!")
                }
                moveCount++
            }
            else -> System.err.println("Invalid Input!")
        }
        println("-----------------------------")
        renderBoard()
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
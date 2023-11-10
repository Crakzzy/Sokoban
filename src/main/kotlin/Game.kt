enum class InputType {
    UP, DOWN, LEFT, RIGHT
}

class Game(private var board: MutableList<String>) {
    private val boxes: MutableList<Box> = mutableListOf()
    private val points: MutableList<Point> = mutableListOf()
    private val player = Player(0, 0)

    init {
        for (i in 0..<board.size) {
            for (j in 0..<board[i].length) {
                if (board[i][j] == 'B' && board[i][j] == 'G') {
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
        if (counter == points.size) {
            return true
        }
        return false
    }

    fun move(input: Char) {
        when (input) {
            'w' -> {
                if (!player.move(InputType.UP, boxes, board, points)) {
                    System.err.println("Can't move there!")
                }
            }
            'a' -> {
                if (!player.move(InputType.LEFT, boxes, board, points)) {
                    System.err.println("Can't move there!")
                }
            }
            's' -> {
                if (!player.move(InputType.DOWN, boxes, board, points)) {
                    System.err.println("Can't move there!")
                }
            }
            'd' -> {
                if (!player.move(InputType.RIGHT, boxes, board, points)) {
                    System.err.println("Can't move there!")
                }
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
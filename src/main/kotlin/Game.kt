import java.io.File

enum class InputType {
    UP, DOWN, LEFT, RIGHT
}

class Game {
    var moveCount: Int = 0
    private var board: MutableList<String> = getLevel()
    private val initialBoardState: List<String> = board.toList()
    private val boxes: MutableList<Box> = mutableListOf()
    private val points: MutableList<Point> = mutableListOf()
    private val player = Player(0, 0)

    init {
        initializeGameObjects()
    }

    private fun getLevel(path: String = "src/main/resources/level.txt"): MutableList<String> {
        val fileLines: List<String> = File(path).readLines()
        val board: MutableList<String> = mutableListOf()
        fileLines.forEach {
            board.add(it)
        }
        return board
    }

    private fun initializeGameObjects() {
        for (i in 0..<board.size) {
            for (j in 0..<board[i].length) {
                if (board[i][j] == 'B') {
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

    fun resetBoard() {
        board.clear()
        boxes.clear()
        points.clear()
        board.addAll(initialBoardState)
        moveCount = 0
        initializeGameObjects()
        println("-----------------------------")
        renderBoard()
    }
}
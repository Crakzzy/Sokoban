import java.io.File
import kotlin.system.exitProcess

enum class InputType {
    UP, DOWN, LEFT, RIGHT
}

const val BOX = 'B'
const val POINT = 'O'
const val PLAYER = 'P'
const val WALL = 'X'
const val GOOD = 'G'

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
        try {
            File(path).readLines()
        } catch (e: Exception) {
            System.err.println("File not found!")
            exitProcess(1)
        }
        return File(path).readLines().toMutableList()
    }

    private fun initializeGameObjects() {
        for (i in 0..<board.size) {
            for (j in 0..<board[i].length) {
                if (board[i][j] == BOX) {
                    boxes.add(Box(j, i))
                } else if (board[i][j] == POINT) {
                    points.add(Point(j, i))
                } else if (board[i][j] == PLAYER) {
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
                if (char == GOOD) {
                    counter++
                }
            }
        }
        return counter == points.size
    }

    fun move(input: Char) {
        when (input) {
            'w' -> {
                if (!player.turn(InputType.UP, boxes, board, points)) {
                    System.err.println("Can't turn there!")
                }
                moveCount++
            }

            'a' -> {
                if (!player.turn(InputType.LEFT, boxes, board, points)) {
                    System.err.println("Can't turn there!")
                }
                moveCount++
            }

            's' -> {
                if (!player.turn(InputType.DOWN, boxes, board, points)) {
                    System.err.println("Can't turn there!")
                }
                moveCount++
            }

            'd' -> {
                if (!player.turn(InputType.RIGHT, boxes, board, points)) {
                    System.err.println("Can't turn there!")
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
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


    fun move(input: Char) {

        when (input) {
            'w' -> player.move(InputType.UP, boxes, board)
            'a' -> player.move(InputType.LEFT, boxes, board)
            's' -> player.move(InputType.DOWN, boxes, board)
            'd' -> player.move(InputType.RIGHT, boxes, board)
            else -> System.err.println("Invalid Input!")
        }
        println("-----------------------------")
        renderBoard()


        /*if (validateInput(input)) {
            if (player.move(input, boxes, board)) {
                println("--------------------------------")
                renderBoard()
            } else {
                println("Can't move there!")
                println("--------------------------------")
                renderBoard()
            }
        }*/
    }

    private fun validateInput(input: Char): Boolean {
        return input == 'w' || input == 'a' || input == 's' || input == 'd'
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


/*fun printBoxes() {
        for (element in boxes ){
            println(element.x)
        }
    }*/
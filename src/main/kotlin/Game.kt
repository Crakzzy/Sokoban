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
                    points.add(Point(j,i))
                } else if (board[i][j] == 'P') {
                    player.x = j
                    player.y = i
                }
            }
        }
    }


    fun move(input: Char) {

        if (validateInput(input)) {
            if (player.move(input, boxes, board)) {
                println("--------------------------------")
                renderBoard()
            } else {
                println("Can't move there!")
                println("--------------------------------")
                renderBoard()
            }
        } else {
            System.err.println("Invalid input!")
            return
        }
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
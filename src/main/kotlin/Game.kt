class Game(private var board: List<String>) {
    private var boxes: MutableList<Box> = mutableListOf()
    private val player = Player(0, 0)

    init {
        for (i in 0..<board.size) {
            for (j in 0..<board[i].length) {
                if (board[i][j] == 'B') {
                    boxes.add(Box(j, i))
                } else if (board[i][j] == 'P') {
                    player.x = j
                    player.y = i
                }
            }
        }
    }


    fun move(input: Char) {
        if (!validateInput(input)) {
            println("Invalid move")
            return
        }
        if (validateMove(input)) {

        }
    }

    // TODO validation check for other inputs
    private fun validateMove(input: Char): Boolean {
        if (input == 'w') {
            if (board[player.y - 1][player.x] == 'X') { // Check for wall
                return false
            } else if (board[boxes[boxes.indexOfFirst{it.x == 5 && it.y == 4}].y-1][player.x] == 'B' && board[player.y-2][player.x] == 'X' ) { // Check for movable box and wall
                return false
            } else if (board[boxes[boxes.indexOfFirst{it.x == 5 && it.y == 4}].y-1][player.x] == 'B' && board[player.y-2][player.x] == 'B') { // Check for movable box and another box
                return false
            }

        }
        return true
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
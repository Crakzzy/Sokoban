import java.lang.StringBuilder

class Player(var x: Int, var y: Int) {
    fun move(input: Char, boxes: List<Box>, board: MutableList<String>): Boolean {

        return updateBoard(input, boxes, board)
    }

    private fun updateBoard(input: Char, boxes: List<Box>, board: MutableList<String>): Boolean {
        fun validateMove(): Boolean {
            if (input == 'w') {
                val boxIndex = boxes.indexOfFirst { it.x == this.x && it.y == this.y - 1 }
                if (boxIndex != -1) {
                    if (board[this.y - 1][this.x] == 'X') { // Check for wall
                        return false
                    }
                    if (board[boxes[boxIndex].y][this.x] == 'B' && board[this.y - 2][this.x] == 'X') { // Check for movable box and wall
                        return false
                    } else if (board[boxes[boxIndex].y][this.x] == 'B' && board[this.y - 2][this.x] == 'B') { // Check for movable box and another box
                        return false
                    }
                }
                else if (board[this.y - 1][this.x] == 'X') { // Check for wall
                    return false
                }
            }
            return true
        }

        if (validateMove()) {
            if (input == 'w') {

                // Player move from previous position
                val newPlayerFrom = StringBuilder(board[this.y])
                newPlayerFrom.setCharAt(this.x, ' ')

                // Player move from to upper one position (y-1)
                val newPlayerTo = StringBuilder(board[this.y - 1])
                newPlayerTo.setCharAt(this.x, 'P')

                // TODO check for box move - new method, also to implement into validateMove()

                if (board[this.y-1][this.x] == 'B') {
                    val boxIndex = boxes.indexOfFirst { it.x == this.x && it.y == this.y - 1 }
                    boxes[boxIndex].move(input)
                    val newBoxTo = StringBuilder(board[this.y-1])
                    newBoxTo.setCharAt(this.x, 'B')
                    board[this.y-2] = newBoxTo.toString()
                }
                board[this.y] = newPlayerFrom.toString()
                board[this.y - 1] = newPlayerTo.toString()
                this.y--
            }
            return true
        }
        return false
    }

}
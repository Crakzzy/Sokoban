import java.lang.StringBuilder
class Player(var x: Int, var y: Int) {
    fun move(input: Char, boxes: List<Box>, board: MutableList<String>): Boolean {

        return updateBoard(input, boxes, board)
    }

    private fun updateBoard(input: Char, boxes: List<Box>, board: MutableList<String>): Boolean {
        fun validateMove(): Boolean {
            if (input == 'w') {
                val boxIndex =  boxes.indexOfFirst { it.x == this.x && it.y == this.y-1 }
                if (board[this.y - 1][this.x] == 'X') { // Check for wall
                    return false
                } else if (board[boxes[boxIndex].y][this.x] == 'B' && board[this.y - 2][this.x] == 'X') { // Check for movable box and wall
                    return false
                } else if (board[boxes[boxIndex].y][this.x] == 'B' && board[this.y - 2][this.x] == 'B') { // Check for movable box and another box
                    return false
                }
            }
            return true
        }

        if (validateMove()) {
            if (input == 'w') {

                // Player move from previous position
                val newStringFrom = StringBuilder(board[this.y])
                newStringFrom.setCharAt(this.x, ' ')
                board[this.y] = newStringFrom.toString()

                // Player move from to upper one position (y-1)
                val newStringTo = StringBuilder(board[this.y-1])
                newStringTo.setCharAt(this.y-1, 'P')
                board[this.y-1]= newStringTo.toString()

                // TODO check for box move - new method, also to implement into validateMove()

            }
            return true
        }
        return false
    }

}
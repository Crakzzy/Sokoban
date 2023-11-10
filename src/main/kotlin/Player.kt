import java.lang.StringBuilder

class Player(var x: Int, var y: Int) {
    fun move(input: InputType, boxes: List<Box>, board: MutableList<String>): Boolean {
        return updateBoard(input, boxes, board)
    }

    private fun validateMove(input: InputType, boxes: List<Box>, board: MutableList<String>): Boolean {
        when (input) {
            InputType.UP -> {
                val box =
                    boxes.firstOrNull { it.x == this.x && it.y == this.y - 1 } // Find a box in the way of player move
                if (box != null) {
                    if (board[box.y][this.x] == 'B' && board[this.y - 2][this.x] == 'X') { // Check for movable box and wall
                        return false
                    } else if (board[box.y][this.x] == 'B' && board[this.y - 2][this.x] == 'B') { // Check for movable box and another box
                        return false
                    }
                } else if (board[this.y - 1][this.x] == 'X') { // Check for wall
                    return false
                }
            }
            InputType.DOWN -> {
                val box = boxes.firstOrNull { it.x == this.x && it.y == this.y + 1 }
                if (box != null) {
                    if (board[box.y][this.x] == 'B' && board[this.y + 2][this.x] == 'X') { // Check for movable box and wall
                        return false
                    } else if (board[box.y][this.x] == 'B' && board[this.y + 2][this.x] == 'B') { // Check for movable box and another box
                        return false
                    }
                } else if (board[this.y + 1][this.x] == 'X') {
                    return false
                }
            }

            else -> {}
        }
        return true
    }

    private fun updateBoard(input: InputType, boxes: List<Box>, board: MutableList<String>): Boolean {
        if (validateMove(input, boxes, board)) {
            when (input) {
                InputType.UP -> {
                    // Player move from previous position
                    val newPlayerFrom = StringBuilder(board[this.y])
                    newPlayerFrom.setCharAt(this.x, ' ')

                    // Player move to upper one position (y-1)
                    val newPlayerTo = StringBuilder(board[this.y - 1])
                    newPlayerTo.setCharAt(this.x, 'P')

                    if (board[this.y - 1][this.x] == 'B') {
                        val box = boxes.firstOrNull { it.x == this.x && it.y == this.y - 1 }
                        box?.move(input)
                        val newBoxTo = StringBuilder(board[this.y - 2])
                        newBoxTo.setCharAt(this.x, 'B')
                        board[this.y - 2] = newBoxTo.toString()
                    }
                    board[this.y] = newPlayerFrom.toString()
                    board[this.y - 1] = newPlayerTo.toString()
                    this.y--
                }

                InputType.DOWN -> {
                    // Player move from previous position
                    val newPlayerFrom = StringBuilder(board[this.y])
                    newPlayerFrom.setCharAt(this.x, ' ')

                    // Player move to one down position (y+1)
                    val newPlayerTo = StringBuilder(board[this.y + 1])
                    newPlayerTo.setCharAt(this.x, 'P')

                    if (board[this.y + 1][this.x] == 'B') {
                        val box = boxes.firstOrNull { it.x == this.x && it.y == this.y + 1 }
                        box?.move(input)
                        val newBoxTo = StringBuilder(board[this.y + 2])
                        newBoxTo.setCharAt(this.x, 'B')
                        board[this.y + 2] = newBoxTo.toString()
                    }
                    board[this.y] = newPlayerFrom.toString()
                    board[this.y + 1] = newPlayerTo.toString()
                    this.y++
                }

                else -> {}
            }
            return true
        }
        return false
    }
}
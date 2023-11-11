import java.lang.StringBuilder

class Player(var x: Int, var y: Int) {
    fun move(input: InputType, boxes: List<Box>, board: MutableList<String>, points: MutableList<Point>): Boolean {
        return updateBoard(input, boxes, board, points)
    }

    private fun validateMove(input: InputType, boxes: List<Box>, board: MutableList<String>): Boolean {
        when (input) {
            InputType.UP -> {
                if (validateMoveUp(boxes, board)) {
                    return true
                }
            }

            InputType.DOWN -> {
                if (validateMoveDown(boxes, board)) {
                    return true
                }
            }

            InputType.LEFT -> {
                if (validateMoveLeft(boxes, board)) {
                    return true
                }
            }

            InputType.RIGHT -> {
                if (validateMoveRight(boxes, board)) {
                    return true
                }
            }

        }
        return false
    }

    private fun validateMoveUp(boxes: List<Box>, board: MutableList<String>): Boolean {
        val box =
            boxes.firstOrNull { it.x == this.x && it.y == this.y - 1 } // Find a box in the way of player move
        if (box != null) {
            if (board[this.y - 2][this.x] == WALL || board[this.y - 2][this.x] == BOX) { // Check for movable box and wall
                return false
            }
        } else if (board[this.y - 1][this.x] == WALL) { // Check for wall
            return false
        }
        return true
    }

    private fun validateMoveDown(boxes: List<Box>, board: MutableList<String>): Boolean {
        val box = boxes.firstOrNull { it.x == this.x && it.y == this.y + 1 }
        if (box != null) {
            if (board[this.y + 2][this.x] == WALL || board[this.y + 2][this.x] == BOX) { // Check for movable box and wall
                return false
            }
        } else if (board[this.y + 1][this.x] == WALL) {
            return false
        }
        return true
    }

    private fun validateMoveLeft(boxes: List<Box>, board: MutableList<String>): Boolean {
        val box =
            boxes.firstOrNull { it.x == this.x - 1 && it.y == this.y } // Find a box in the way of player move
        if (box != null) {
            if (board[this.y][this.x - 2] == WALL || board[this.y][this.x - 2] == BOX) { // Check for movable box and wall
                return false
            }
        } else if (board[this.y][this.x - 1] == WALL) { // Check for wall
            return false
        }
        return true
    }

    private fun validateMoveRight(boxes: List<Box>, board: MutableList<String>): Boolean {
        val box =
            boxes.firstOrNull { it.x == this.x + 1 && it.y == this.y } // Find a box in the way of player move
        if (box != null) {
            if (board[this.y][this.x + 2] == WALL || board[this.y][this.x + 2] == BOX) { // Check for movable box and wall
                return false
            }
        } else if (board[this.y][this.x + 1] == WALL) { // Check for wall
            return false
        }
        return true
    }

    // Change last position of player to corresponding character
    private fun lastPosition(board: MutableList<String>, point: Point?): String {
        val newPlayerFrom = StringBuilder(board[this.y])
        if (point != null) {
            newPlayerFrom.setCharAt(this.x, POINT)
            return newPlayerFrom.toString()
        }
        newPlayerFrom.setCharAt(this.x, ' ')
        return newPlayerFrom.toString()
    }

    private fun updateBoard(
        input: InputType,
        boxes: List<Box>,
        board: MutableList<String>,
        points: MutableList<Point>
    ): Boolean {
        if (validateMove(input, boxes, board)) {
            val point = points.firstOrNull { it.x == this.x && it.y == this.y }
            when (input) {
                InputType.UP -> moveUp(input, point, boxes, board, points)
                InputType.DOWN -> moveDown(input, point, boxes, board, points)
                InputType.LEFT -> moveLeft(input, point, boxes, board, points)
                InputType.RIGHT -> moveRight(input, point, boxes, board, points)
            }
            return true
        }
        return false
    }

    private fun moveUp(
        input: InputType,
        point: Point?,
        boxes: List<Box>,
        board: MutableList<String>,
        points: MutableList<Point>
    ) {
        // Player move from previous position,
        val newPlayerFrom = lastPosition(board, point)

        // Player move to upper one position (y-1)
        val newPlayerTo = StringBuilder(board[this.y - 1])
        newPlayerTo.setCharAt(this.x, PLAYER)

        if (board[this.y - 1][this.x] == BOX || board[this.y - 1][this.x] == TICK) {
            val box = boxes.firstOrNull { it.x == this.x && it.y == this.y - 1 }
            box?.move(input)
            val newBoxTo = StringBuilder(board[this.y - 2])
            newBoxTo.setCharAt(this.x, BOX)
            board[this.y - 2] = newBoxTo.toString()
            box?.isBoxPlaced(board, points)
        }
        board[this.y] = newPlayerFrom
        board[this.y - 1] = newPlayerTo.toString()
        this.y--
    }

    private fun moveDown(
        input: InputType,
        point: Point?,
        boxes: List<Box>,
        board: MutableList<String>,
        points: MutableList<Point>
    ) {
        // Player move from previous position
        val newPlayerFrom = lastPosition(board, point)

        // Player move to one down position (y+1)
        val newPlayerTo = StringBuilder(board[this.y + 1])
        newPlayerTo.setCharAt(this.x, PLAYER)

        if (board[this.y + 1][this.x] == BOX || board[this.y + 1][this.x] == TICK) {
            val box = boxes.firstOrNull { it.x == this.x && it.y == this.y + 1 }
            box?.move(input)
            val newBoxTo = StringBuilder(board[this.y + 2])
            newBoxTo.setCharAt(this.x, BOX)
            board[this.y + 2] = newBoxTo.toString()
            box?.isBoxPlaced(board, points)
        }
        board[this.y] = newPlayerFrom
        board[this.y + 1] = newPlayerTo.toString()
        this.y++
    }

    private fun moveLeft(
        input: InputType,
        point: Point?,
        boxes: List<Box>,
        board: MutableList<String>,
        points: MutableList<Point>
    ) {
        // Check for box first
        if (board[this.y][this.x - 1] == BOX || board[this.y][this.x - 1] == TICK) {
            val box = boxes.firstOrNull { it.x == this.x - 1 && it.y == this.y }
            box?.move(input)
            val newBoxTo = StringBuilder(board[this.y])
            newBoxTo.setCharAt(this.x - 2, BOX)
            board[this.y] = newBoxTo.toString()
            box?.isBoxPlaced(board, points)
        }

        // Player move from previous position
        val newPlayerFrom = lastPosition(board, point)

        // Player move to one left position (x-1)
        val newPlayerTo = StringBuilder(newPlayerFrom)
        newPlayerTo.setCharAt(this.x - 1, PLAYER)
        board[this.y] = newPlayerTo.toString()
        this.x--
    }

    private fun moveRight(
        input: InputType,
        point: Point?,
        boxes: List<Box>,
        board: MutableList<String>,
        points: MutableList<Point>
    ) {
        // Check for box first
        if (board[this.y][this.x + 1] == BOX || board[this.y][this.x + 1] == TICK) {
            val box = boxes.firstOrNull { it.x == this.x + 1 && it.y == this.y }
            box?.move(input)
            val newBoxTo = StringBuilder(board[this.y])
            newBoxTo.setCharAt(this.x + 2, BOX)
            board[this.y] = newBoxTo.toString()
            box?.isBoxPlaced(board, points)
        }

        // Player move from previous position
        val newPlayerFrom = lastPosition(board, point)

        // Player move to one right position (x+1)
        val newPlayerTo = StringBuilder(newPlayerFrom)
        newPlayerTo.setCharAt(this.x + 1, PLAYER)
        board[this.y] = newPlayerTo.toString()
        this.x++
    }
}
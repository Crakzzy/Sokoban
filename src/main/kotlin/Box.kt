import java.lang.StringBuilder

class Box(var x: Int, var y: Int) {
    fun move(input: InputType) {
        when (input) {
            InputType.UP -> this.y--
            InputType.DOWN -> this.y++
            InputType.LEFT -> this.x--
            InputType.RIGHT -> this.x++
        }

    }

    fun isBoxPlaced(board: MutableList<String>, points: MutableList<Point>) {
        for ((strIndex, str) in board.withIndex()) {
            for ((charIndex, char) in str.withIndex()) {
                if (char == BOX) {
                    if (points.firstOrNull { it.x == charIndex && it.y == strIndex } != null) {
                        val newString = StringBuilder(board[strIndex])
                        newString.setCharAt(charIndex, TICK)
                        board[strIndex] = newString.toString()
                    }
                }
            }
        }
    }
}
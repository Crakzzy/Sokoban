class Box(var x: Int, var y: Int) {
    fun move(input: InputType) {
        when (input) {
            InputType.UP -> this.y--
            InputType.DOWN -> this.y++
            InputType.LEFT -> this.x--
            InputType.RIGHT -> this.x++
        }

    }
}
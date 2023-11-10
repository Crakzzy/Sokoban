class Box(var x: Int, var y: Int) {
    fun move(input: InputType) {
        if (input == InputType.UP) {
            this.y--
        }
    }
}
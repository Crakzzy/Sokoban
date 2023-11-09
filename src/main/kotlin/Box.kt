class Box(var x: Int, var y: Int) {
    fun move(input: Char) {
        if (input == 'w') {
            this.y--
        }
    }
}
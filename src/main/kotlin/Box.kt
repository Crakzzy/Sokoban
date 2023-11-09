class Box(var x: Int, var y: Int) {

    fun move(input: Char): Boolean {
        // TODO Validate move for box

        if (input == 'w') {
            this.y--
        }
        return true
    }

}
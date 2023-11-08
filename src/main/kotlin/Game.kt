class Game {

    var board = Array(10) { Array<Any?> (10) {null} }

    init {
      //  board =
    }



   fun printBoard() {
       for (i in 0 .. 9) {
           for (j in 0 .. 9) {
               print(board[i][j])
           }
           println()
       }
   }
}
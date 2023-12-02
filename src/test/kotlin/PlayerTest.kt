import junit.framework.TestCase.assertEquals
import org.junit.Test

class PlayerTest {
    @Test
    fun test_move_on_empty_board() {
        val board = mutableListOf("     ", "     ", "     ", "     ", "     ")
        val player = Player(2, 2)

        val resultUp = player.turn(InputType.UP, emptyList(), board, mutableListOf())
        val resultDown = player.turn(InputType.DOWN, emptyList(), board, mutableListOf())
        val resultLeft = player.turn(InputType.LEFT, emptyList(), board, mutableListOf())
        val resultRight = player.turn(InputType.RIGHT, emptyList(), board, mutableListOf())

        assertEquals(true, resultUp)
        assertEquals(true, resultDown)
        assertEquals(true, resultLeft)
        assertEquals(true, resultRight)
    }

    @Test
    fun test_push_box() {
        val board = mutableListOf("     ", "  P  ", "  B  ", "     ", "     ")
        val player = Player(2, 1)
        val box = Box(2, 2)

        val resultUp = player.turn(InputType.UP, listOf(box), board, mutableListOf())
        val resultDown = player.turn(InputType.DOWN, listOf(box), board, mutableListOf())
        val resultLeft = player.turn(InputType.LEFT, listOf(box), board, mutableListOf())
        val resultRight = player.turn(InputType.RIGHT, listOf(box), board, mutableListOf())

        assertEquals(true, resultUp)
        assertEquals(true, resultDown)
        assertEquals(true, resultLeft)
        assertEquals(true, resultRight)
    }
    @Test
    fun test_move_to_tick() {
        val board = mutableListOf("     ", "  P  ", "  ✓  ", "     ", "     ")
        val player = Player(2, 1)

        val result = player.turn(InputType.DOWN, emptyList(), board, mutableListOf())

        assertEquals(true, result)
    }
    @Test
    fun test_push_box_to_point() {
        val board = mutableListOf("     ", "  P  ", "  B  ", "  O  ", "     ")
        val player = Player(2, 1)
        val box = Box(2, 2)
        val point = Point(2, 3)

        val result = player.turn(InputType.DOWN, listOf(box), board, mutableListOf(point))

        assertEquals(true, result)
    }

    @Test
    fun test_push_box_to_tick() {
        val board = mutableListOf("     ", "  P  ", "  B  ", "  ✓  ", "     ")
        val player = Player(2, 1)
        val box = Box(2, 2)

        val result = player.turn(InputType.DOWN, listOf(box), board, mutableListOf())

        assertEquals(true, result)
    }
    @Test
    fun test_cannot_move_into_wall() {
        val board = mutableListOf("     ", "  P  ", "  X  ", "     ", "     ")
        val player = Player(2, 1)

        val result = player.turn(InputType.DOWN, emptyList(), board, mutableListOf())

        assertEquals(false, result)
    }
}
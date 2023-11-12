import junit.framework.TestCase.assertEquals
import org.junit.Test

class BoxTest {

    @Test
    fun test_box_creation() {
        val box = Box(0, 0)
        assertEquals(0, box.x)
        assertEquals(0, box.y)
    }

    @Test
    fun test_box_movement() {
        val box = Box(0, 0)
        box.move(InputType.UP)
        assertEquals(-1, box.y)
        box.move(InputType.DOWN)
        assertEquals(0, box.y)
        box.move(InputType.LEFT)
        assertEquals(-1, box.x)
        box.move(InputType.RIGHT)
        assertEquals(0, box.x)
    }


    @Test
    fun test_is_box_placed_on_point() {
        val board = mutableListOf("B")
        val points = mutableListOf(Point(0, 0))
        val box = Box(0, 0)
        box.isBoxPlaced(board, points)
        assertEquals("✓", board[0])
    }

    @Test
    fun test_mark_box_position_on_board() {
        val board = mutableListOf("B")
        val points = mutableListOf(Point(0, 0))
        val box = Box(0, 0)
        box.isBoxPlaced(board, points)
        assertEquals("✓", board[0])
    }

    @Test
    fun test_box_not_placed_on_point() {
        val board = mutableListOf("B")
        val points = mutableListOf(Point(1, 0))
        val box = Box(0, 0)
        box.isBoxPlaced(board, points)
        assertEquals("B", board[0])
    }

    @Test
    fun test_multiple_points_on_board() {
        val board = mutableListOf("B")
        val points = mutableListOf(Point(0, 0), Point(1, 0))
        val box = Box(0, 0)
        box.isBoxPlaced(board, points)
        assertEquals("✓", board[0])
    }

    @Test
    fun test_negative_coordinates() {
        val box = Box(0, 0)
        box.move(InputType.UP)
        assertEquals(-1, box.y)
        box.move(InputType.LEFT)
        assertEquals(-1, box.x)
    }

    @Test
    fun test_empty_board() {
        val board = mutableListOf<String>()
        val points = mutableListOf(Point(0, 0))
        val box = Box(0, 0)
        box.isBoxPlaced(board, points)
        assertEquals(0, board.size)
    }

    @Test
    fun test_no_points_on_board() {
        val board = mutableListOf("B")
        val points = mutableListOf<Point>()
        val box = Box(0, 0)
        box.isBoxPlaced(board, points)
        assertEquals("B", board[0])
    }

    @Test
    fun test_board_contains_other_characters() {
        val board = mutableListOf("B#")
        val points = mutableListOf(Point(0, 0))
        val box = Box(0, 0)
        box.isBoxPlaced(board, points)
        assertEquals("✓#", board[0])
    }

    @Test
    fun test_board_contains_non_ascii_characters() {
        val board = mutableListOf("B😀")
        val points = mutableListOf(Point(0, 0))
        val box = Box(0, 0)
        box.isBoxPlaced(board, points)
        assertEquals("✓😀", board[0])
    }
}

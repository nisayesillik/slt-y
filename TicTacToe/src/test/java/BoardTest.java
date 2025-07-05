import org.example.Board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    //Tests für isCellEmpty
    @Test
    public void testIsCellEmptyTrueOnNewBoard() {
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    public void testIsCellEmptyFalseAfterPlacement() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    //Tests für place
    @Test
    public void testPlaceSetsCorrectMarker() {
        board.place(2, 2, 'O');
        assertEquals('O', board.getCells()[2][2]);
    }

    @Test
    public void testPlaceOverwritesCell() {
        board.place(0, 1, 'X');
        board.place(0, 1, 'O');  // Achtung: kein Schutz vor Überschreiben!
        assertEquals('O', board.getCells()[0][1]);
    }

    //Tests für clear

    @Test
    public void testClearEmptiesBoard() {
        board.place(1, 1, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    public void testClearAllCellsEmpty() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(1, 1, 'X');
        board.clear();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                assertTrue(board.isCellEmpty(i, j));
    }

    //Tests für getCells
    @Test
    public void testGetCellsReturnsCorrectSize() {
        char[][] cells = board.getCells();
        assertEquals(3, cells.length);
        assertEquals(3, cells[0].length);
    }

    @Test
    public void testGetCellsReflectsChanges() {
        board.place(2, 1, 'X');
        assertEquals('X', board.getCells()[2][1]);
    }
}

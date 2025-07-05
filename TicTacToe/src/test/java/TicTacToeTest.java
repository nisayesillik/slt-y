import org.example.Player;
import org.example.TicTacToe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    // 1. Positiver Test: Gültiger Zug platziert Marker
    @Test
    public void testMakeMoveValidPlacement() {
        game.makeMove(1, 1);
        assertEquals('X', game.getBoard().getCells()[1][1]);
    }

    // 2. Negativer Test: Ungültige Koordinaten
    @Test
    public void testMakeMoveInvalidCoordinates() {
        game.makeMove(-1, 5);
        char[][] cells = game.getBoard().getCells();
        for (char[] row : cells) {
            for (char cell : row) {
                assertEquals(' ', cell);
            }
        }
    }

    // 3. Negativer Test: Feld ist bereits belegt
    @Test
    public void testMakeMoveOnOccupiedCell() {
        game.makeMove(0, 0);
        game.makeMove(0, 0);
        assertEquals('X', game.getBoard().getCells()[0][0]);
    }

    // 4. Positiver Test: Spielerwechsel nach gültigem Zug
    @Test
    public void testPlayerSwitchAfterMove() {
        Player currentBefore = game.getCurrentPlayer();
        game.makeMove(1, 1);
        Player currentAfter = game.getCurrentPlayer();
        assertNotEquals(currentBefore, currentAfter);
    }

    // 5. Positiver Test: Spieler X beginnt immer
    @Test
    public void testInitialPlayerIsX() {
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    // 6. Positiver Test: getBoard() liefert nicht-null Board
    @Test
    public void testGetBoardNotNull() {
        assertNotNull(game.getBoard());
    }

    // 7. Negativer Test: Kein Spielerwechsel bei ungültigem Zug
    @Test
    public void testNoPlayerSwitchOnInvalidMove() {
        game.makeMove(0, 0); // Spieler X
        Player before = game.getCurrentPlayer(); // Sollte O sein
        game.makeMove(0, 0); // O versucht dieselbe Zelle
        Player after = game.getCurrentPlayer();  // Sollte immer noch O sein
        assertEquals(before, after);
    }

}

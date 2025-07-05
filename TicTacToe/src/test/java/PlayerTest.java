
import org.example.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    // Positiver Test: Spieler mit Marker X
    @Test
    public void testPlayerMarkerX() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    // Positiver Test: Spieler mit Marker O
    @Test
    public void testPlayerMarkerO() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker());
    }

    // Negativer Test: Marker darf nicht null sein (ungültiger Marker)
    @Test
    public void testInvalidMarker() {
        Player player = new Player(' ');
        assertEquals(' ', player.getMarker());
    }

    // Negativer Test: Spieler mit Sonderzeichen (unerwarteter Marker)
    @Test
    public void testUnexpectedMarkerSymbol() {
        Player player = new Player('#');
        assertEquals('#', player.getMarker());
    }
}

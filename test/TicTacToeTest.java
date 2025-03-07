import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe('X'); // Or 'O', doesn't matter for these tests
    }

    @Test
    void testResetBoard() {
        // Make some moves to fill the board partially
        game.buttons[0][0].setText("X");
        game.buttons[1][1].setText("O");
        game.buttons[2][2].setText("X");

        game.resetBoard();

        // Assert that all buttons are now empty
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(" ", game.buttons[i][j].getText(), "Board should be reset to empty.");
            }
        }
    }

    @Test
    void testIsBoardFull_DrawCondition() {
        // Fill the board to represent a draw
        game.buttons[0][0].setText("X");
        game.buttons[0][1].setText("O");
        game.buttons[0][2].setText("X");
        game.buttons[1][0].setText("O");
        game.buttons[1][1].setText("X");
        game.buttons[1][2].setText("O");
        game.buttons[2][0].setText("O");
        game.buttons[2][1].setText("X");
        game.buttons[2][2].setText("O");

        assertTrue(game.isBoardFull(), "Board should be full in a draw condition.");
    }

    @Test
    void testIsBoardFull_NotFull() {
        // Leave one spot empty
        game.buttons[0][0].setText("X");
        game.buttons[0][1].setText("O");
        game.buttons[0][2].setText("X");
        game.buttons[1][0].setText("O");
        game.buttons[1][1].setText("X");
        game.buttons[1][2].setText("O");
        game.buttons[2][0].setText("O");
        game.buttons[2][1].setText("X");
        //game.buttons[2][2].setText("O"); // Leave this empty

        assertFalse(game.isBoardFull(), "Board should NOT be full.");
    }
}

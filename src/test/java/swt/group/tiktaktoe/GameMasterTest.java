package swt.group.tiktaktoe;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class GameMasterTest {
    private GameState state;
    private GameMaster gameMaster;

    @BeforeEach
    void setUp() {
        state = new GameState();
        gameMaster = new GameMaster(state);
    }

    @ParameterizedTest
    @EnumSource(value = GameTileType.class, names = { "Cross", "Circle" })
    void winnerRow(GameTileType player) {
        assertFalse(gameMaster.doTurn(0, 0, player));
        assertFalse(gameMaster.doTurn(1, 0, player));
        assertTrue(gameMaster.doTurn(2, 0, player));
    }

    @ParameterizedTest
    @EnumSource(value = GameTileType.class, names = { "Cross", "Circle" })
    void winnerColumn(GameTileType player) {
        assertFalse(gameMaster.doTurn(0, 0, player));
        assertFalse(gameMaster.doTurn(0, 1, player));
        assertTrue(gameMaster.doTurn(0, 2, player));
    }

    @ParameterizedTest
    @EnumSource(value = GameTileType.class, names = { "Cross", "Circle" })
    void winnerDiagonal(GameTileType player) {
        assertFalse(gameMaster.doTurn(0, 0, player));
        assertFalse(gameMaster.doTurn(1, 1, player));
        assertTrue(gameMaster.doTurn(2, 2, player));
    }
}

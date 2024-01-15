package swt.group.tiktaktoe;

public class GameMaster {
    private GameState state;

    public GameMaster() {
        this(new GameState());
    }

    public GameMaster(GameState state) {
        if (state == null)
            throw new IllegalArgumentException("state is null.");

        this.state = state;
    }

    public GameState getState() {
        return state;
    }

    public void reset() {
        state.fill(GameTileType.None);
    }

    public boolean doTurn(int x, int y, GameTileType tile) {
        if (state.getTile(x, y) != GameTileType.None)
            throw new UnsupportedOperationException("Tile is already set.");

        state.setTile(x, y, tile);

        var win = true;
        for (int row = 0; row < 3; row++) {
            win &= state.getTile(x, row) == tile;
        }
        if (win)
            return true;

        win = true;
        for (int column = 0; column < 3; column++) {
            win &= state.getTile(column, y) == tile;
        }
        if (win)
            return true;

        if (x == y || x == 2 - y) {
            win = true;
            for (int i = 0; i < 3; i++) {
                win &= state.getTile(i, i) == tile;
            }
            if (win)
                return true;

            win = true;
            for (int i = 0; i < 3; i++) {
                win &= state.getTile(i, 2 - i) == tile;
            }
            if (win)
                return true;
        }

        return false;
    }

    /**
     * Checks if the game is over and returns the winner
     * 
     * @return GameTileType
     * @author Shantanu Biradar
     */
    public GameTileType getWinner() {
        // Check across the rows and columns
        for (int i = 0; i < 3; i++) {
            if (state.getTile(i, 0) != GameTileType.None && state.getTile(i, 0) == state.getTile(i, 1)
                    && state.getTile(i, 1) == state.getTile(i, 2)) {
                return state.getTile(i, 0);
            }
            if (state.getTile(0, i) != GameTileType.None && state.getTile(0, i) == state.getTile(1, i)
                    && state.getTile(1, i) == state.getTile(2, i)) {
                return state.getTile(0, i);
            }
        }

        // Check across the diagonals
        if (state.getTile(0, 0) != GameTileType.None && state.getTile(0, 0) == state.getTile(1, 1)
                && state.getTile(1, 1) == state.getTile(2, 2)) {
            return state.getTile(0, 0);
        }
        if (state.getTile(0, 2) != GameTileType.None && state.getTile(0, 2) == state.getTile(1, 1)
                && state.getTile(1, 1) == state.getTile(2, 0)) {
            return state.getTile(0, 2);
        }

        return GameTileType.None;
    }

    public void nextRound() {
        switch (state.getActivePlayer()) {
            case O:
                state.setActivePlayer(GameTileType.X);
                break;
            case X:
                state.setActivePlayer(GameTileType.O);
                break;
            default:
                break;
        }
    }
}

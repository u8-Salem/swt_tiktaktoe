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

        if (x == y) {
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

    public void nextRound() {
        switch (state.getActivePlayer()) {
            case Circle:
                state.setActivePlayer(GameTileType.Cross);
            case Cross:
                state.setActivePlayer(GameTileType.Circle);
                break;
            default:
                break;
        }
    }
}

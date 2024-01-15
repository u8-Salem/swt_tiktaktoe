package swt.group.tiktaktoe;

public class GameState {
    private GameTileType[][] tiles;
    private GameTileType activePlayer;

    public GameState() {
        this(GameTileType.O);
    }

    public GameState(GameTileType activePlayer) {
        tiles = new GameTileType[3][3];
        fill(GameTileType.None);

        this.activePlayer = activePlayer;
    }

    public void fill(GameTileType tile) {
        for (int i = 0; i < tiles.length; i++) {
            var row = tiles[i];
            for (int j = 0; j < tiles.length; j++) {
                row[j] = tile;
            }
        }
    }

    public GameTileType getTile(int x, int y) {
        return tiles[x][y];
    }

    public void setTile(int x, int y, GameTileType tile) {
        tiles[x][y] = tile;
    }

    public GameTileType getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(GameTileType player) {
        activePlayer = player;
    }

    public boolean isBoardFull() {
        for (var row : tiles) {
            for (var tile : row) {
                if (tile == GameTileType.None) {
                    return false;
                }
            }
        }
        return true;
    }
}

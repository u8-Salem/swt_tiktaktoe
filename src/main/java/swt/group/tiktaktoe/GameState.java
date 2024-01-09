package swt.group.tiktaktoe;

public class GameState {
    private GameTileType[][] tiles;
    private GameTileType activePlayer;

    public GameState() {
        this(GameTileType.Circle);
    }

    public GameState(GameTileType activePlayer) {
        tiles = new GameTileType[3][3];

        for (int i = 0; i < tiles.length; i++) {
            var row = tiles[i];
            for (int j = 0; j < tiles.length; j++) {
                row[j] = GameTileType.None;
            }
        }

        this.activePlayer = activePlayer;
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
}

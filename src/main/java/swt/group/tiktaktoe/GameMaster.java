package swt.group.tiktaktoe;

public class GameMaster {
    private GameState state;

    public GameMaster() {
        this(new GameState());
    }

    public GameMaster(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }

    public void reset() {
        state.fill(GameTileType.None);
    }

    public GameTileType getWinner() {
        throw new UnsupportedOperationException("Not implemented.");
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

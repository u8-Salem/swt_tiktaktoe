package swt.group.tiktaktoe;

public enum GameTileType {
    None,
    X,
    O;

    @Override
    public String toString() {
        switch (this) {
            case None:
                return "";
            case X:
                return "X";
            case O:
                return "O";
            default:
                throw new UnsupportedOperationException("Unknown GameTileType.");
        }
    }
}
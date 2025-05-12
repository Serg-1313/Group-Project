package am.aua.core.buildings;

public class Road {
    private final int playerId;
    private final int fromRow;
    private final int toRow;
    private final int fromColumn;
    private final int toColumn;
    private final int fromCorner;
    private final int toCorner;

    public Road(int playerId, int fromRow, int toRow, int fromColumn, int toColumn, int fromCorner, int toCorner) {
        this.playerId = playerId;
        this.fromRow = fromRow;
        this.toRow = toRow;
        this.fromColumn = fromColumn;
        this.toColumn = toColumn;
        this.fromCorner = fromCorner;
        this.toCorner = toCorner;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getFromRow() {
        return fromRow;
    }

    public int getToRow() {
        return toRow;
    }

    public int getFromColumn() {
        return fromColumn;
    }

    public int getToColumn() {
        return toColumn;
    }

    public int getFromCorner() {
        return fromCorner;
    }

    public int getToCorner() {
        return toCorner;
    }
}

package am.aua.core.board;

import am.aua.core.buildings.BlockedPoint;
import am.aua.core.buildings.Building;
import am.aua.core.buildings.House;
import am.aua.core.buildings.Road;

import java.util.ArrayList;

public class Location {
    private final Building[][] board;
    private final ArrayList<Road> roadMap;

    public Location() {
        roadMap = new ArrayList<>();
        board = new Building[][]{
                {           null,   null,   null            },
                {       null,   null,   null,   null        },
                {       null,   null,   null,   null        },
                {   null,   null,   null,   null,   null    },
                {   null,   null,   null,   null,   null    },
                {null,  null,   null,   null,   null,   null},
                {null,  null,   null,   null,   null,   null},
                {   null,   null,   null,   null,   null    },
                {   null,   null,   null,   null,   null    },
                {       null,   null,   null,   null        },
                {       null,   null,   null,   null        },
                {           null,   null,   null            },
        };
    }

    public Building[][] getBoard() {
        return board;
    }

    public ArrayList<Road> getAllRoads() {
        return roadMap;
    }

    public Building getBuilding(int[] indexes) {
        return board[indexes[0]][indexes[1]];
    }

    public ArrayList<Road> getRoadsFromArea(int row, int column) {
        ArrayList<int[]> possiblePoints = new ArrayList<>();
        ArrayList<Road> roads = new ArrayList<>();
        for(int i = 1; i < 7; i++) {
            possiblePoints.add(getByCorner(row, column, i));
        }

        for(int[] possiblePoint : possiblePoints) {
            for(Road road : roadMap) {
                if(road.getFromRow() == possiblePoint[0]) {
                    roads.add(road);
                }
            }
        }

        return roads;
    }

    public void setSettlement(int playerId, int x, int y, int corner) throws IllegalArgumentException {
        int[] indexes = Location.getByCorner(x, y, corner);
        this.blockSettlementUnavailablePoints(indexes[0], indexes[1]);
        board[indexes[0]][indexes[1]] = new House(playerId);
    }

    public void setRoad(int playerId, int x, int y, int fromCorner, int toCorner) throws IllegalArgumentException {
        int[] fromIndexes = getByCorner(x, y, fromCorner);
        int[] toIndexes = getByCorner(x, y, toCorner);
        Road r = new Road(playerId, fromIndexes[0], fromIndexes[1], toIndexes[0], toIndexes[1], fromCorner, toCorner);
        roadMap.add(r);
    }

    public static int[] getByCorner(int line, int column, int corner) throws IllegalArgumentException {
        int lineRange = (line-1) * 2;
        int rowIndex, columnIndex;
        switch (corner) {
            case 1:
                rowIndex = lineRange;
                if(rowIndex < 6) columnIndex = column-1;
                else columnIndex = column;
                break;
            case 2:
                rowIndex = lineRange+1;
                columnIndex = column-1;
                break;
            case 3:
                rowIndex = lineRange+1;
                columnIndex = column;
                break;
            case 4:
                rowIndex = lineRange+2;
                columnIndex = column-1;
                break;
            case 5:
                rowIndex = lineRange+2;
                columnIndex = column;
                break;
            case 6:
                rowIndex = lineRange+3;
                if(rowIndex < 6) columnIndex = column;
                else columnIndex = column-1;
                break;
            default:
                throw new IllegalArgumentException("Invalid corner!");
        }
        return new int[]{rowIndex, columnIndex-1};
    }

    private void blockSettlementUnavailablePoints(int rowIndex, int columnIndex) throws IllegalArgumentException {
        if(rowIndex%2 == 1) {
            board[rowIndex-1][columnIndex] = new BlockedPoint();
            if (rowIndex != board.length - 1) board[rowIndex+1][columnIndex] = new BlockedPoint();
            if(rowIndex < 6) {
                if(columnIndex != 0) board[rowIndex-1][columnIndex-1] = new BlockedPoint();
            } else {
                if(columnIndex != board[rowIndex-1].length-1) board[rowIndex-1][columnIndex+1] = new BlockedPoint();
            }
        } else {
            board[rowIndex+1][columnIndex] = new BlockedPoint();
            if (rowIndex != 0) board[rowIndex-1][columnIndex] = new BlockedPoint();
            if(rowIndex < 6) {
                if(columnIndex != board[rowIndex-1].length-1) board[rowIndex+1][columnIndex+1] = new BlockedPoint();
            } else {
                if(columnIndex != 0) board[rowIndex+1][columnIndex-1] = new BlockedPoint();
            }
        }
    }
}

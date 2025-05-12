package am.aua.core.actions;

import am.aua.core.Player;
import am.aua.core.board.Board;
import am.aua.core.board.Location;
import am.aua.core.buildings.Building;
import am.aua.core.buildings.Road;
import am.aua.utils.PrintHelper;
import am.aua.utils.TerminalHelper;

import java.util.ArrayList;
import java.util.Scanner;

public class PlacementActions {
    public static int selectLine(Scanner scanner, Board board) {
        PrintHelper.printBoard(board.getAreas());

        return TerminalHelper.askUntilAnswerIsCorrect(scanner, "Please choose which line do you want: ", new String[] {"1", "2", "3", "4", "5"}, false);
    }

    public static int selectArea(Scanner scanner, Location location, Player[] players, Board board, int row) {
        String[] columnOptions = new String[row == 1 || row == 5 ? 3 : row == 2 || row == 4 ? 4 : 5];
        for(int i = 0; i < columnOptions.length; i++) columnOptions[i] = i+1 + "";
        int column = TerminalHelper.askUntilAnswerIsCorrect(scanner, "Please choose which one do you want in your chosen line: ", columnOptions, false);
        PrintHelper.printArea(players, location, board, row, column);

        return column;
    }

    public static int selectCornerForBuilding(Scanner scanner, Location location, int row, int column) {
        ArrayList<String> cornerOptions = new ArrayList<>();
        for(int i = 1; i < 7; i++) {
            Building building = location.getBuilding(Location.getByCorner(row, column, i));
            if(building == null) cornerOptions.add(i + "");
        }
        cornerOptions.add("8");
        return TerminalHelper.askUntilAnswerIsCorrect(scanner, "Please choose in which corner do you want to set your settlement: (Please select the option which contains 8 for going back and changing area!)", cornerOptions.toArray(new String[0]), true);
    }

    public static int selectStartCornerForRoad(Scanner scanner, Location location, int row, int column) {
        ArrayList<String> cornerOptions = new ArrayList<>();
        for(int i = 1; i < 7; i++) cornerOptions.add(i + "");
        ArrayList<Road> roads = location.getRoadsFromArea(row, column);
        int flagForFirstPoint = 0;
        for(Road road : roads) {
            if(road.getFromCorner() == 1) {
                if(road.getToCorner() == 2 || road.getToCorner() == 3) {
                    if(flagForFirstPoint == 2) continue;
                    if(flagForFirstPoint == 1) {
                        flagForFirstPoint++;
                        cornerOptions.remove("1");
                        continue;
                    }
                    flagForFirstPoint++;
                    continue;
                }
            }
            if(road.getFromCorner() == 2) cornerOptions.remove("2");
            if(road.getFromCorner() == 3) cornerOptions.remove("3");
            if(road.getFromCorner() == 4) cornerOptions.remove("4");
            if(road.getFromCorner() == 5) cornerOptions.remove("5");
        }
        cornerOptions.remove("6");
        cornerOptions.add("8");
        return TerminalHelper.askUntilAnswerIsCorrect(scanner, "Please choose in which corner do you want to start your road: (Please select the option which contains 8 for going back and changing area!)", cornerOptions.toArray(new String[0]), true);
    }

    public static int selectEndCornerForRoad(Scanner scanner, Location location, int row, int column, int startCorner) {
        ArrayList<String> cornerOptions = new ArrayList<>();
        for(int i = startCorner+1; i < 7; i++) cornerOptions.add(i + "");
        ArrayList<Road> roads = location.getRoadsFromArea(row, column);
        cornerOptions.remove("1");
        if(startCorner == 1) {
            cornerOptions.remove("4");
            cornerOptions.remove("5");
            cornerOptions.remove("6");
        } else if(startCorner == 2) {
            cornerOptions.remove("3");
            cornerOptions.remove("5");
            cornerOptions.remove("6");
        } else if(startCorner == 3) {
            cornerOptions.remove("4");
            cornerOptions.remove("6");
        } else if(startCorner == 4) {
            cornerOptions.remove("5");
        }

        int flagForLastPoint = 0;
        for(Road road : roads) {
            if(road.getToCorner() == 2 && cornerOptions.contains("2")) cornerOptions.remove("2");
            else if(road.getToCorner() == 3 && cornerOptions.contains("3")) cornerOptions.remove("3");
            else if(road.getToCorner() == 4 && cornerOptions.contains("4")) cornerOptions.remove("4");
            else if(road.getToCorner() == 5 && cornerOptions.contains("5")) cornerOptions.remove("5");
            else if(road.getToCorner() == 6 && cornerOptions.contains("6")) {
                if(road.getFromCorner() == 4 || road.getFromCorner() == 5) {
                    if(flagForLastPoint == 2) continue;
                    if(flagForLastPoint == 1) {
                        flagForLastPoint++;
                        cornerOptions.remove("6");
                        continue;
                    }
                    flagForLastPoint++;
                }
            }
        }
        return TerminalHelper.askUntilAnswerIsCorrect(scanner, "Please choose in which corner do you want to end your road: ", cornerOptions.toArray(new String[0]), true);
    }

    public static void selectAndSetSettlement(Scanner scanner, Location location, Player[] players, Board board, int playerId) {
        int row = PlacementActions.selectLine(scanner, board);
        int column = PlacementActions.selectArea(scanner, location, players, board, row);
        int corner = PlacementActions.selectCornerForBuilding(scanner, location, row, column);
        while (corner == 8) {
            row = PlacementActions.selectLine(scanner, board);
            column = PlacementActions.selectArea(scanner, location, players, board, row);
            corner = PlacementActions.selectCornerForBuilding(scanner, location, row, column);
        }

        location.setSettlement(playerId, row, column, corner);
    }

    public static void selectAndSetRoad(Scanner scanner, Location location, Player[] players, Board board, int playerId) {
        int row = PlacementActions.selectLine(scanner, board);
        int column = PlacementActions.selectArea(scanner, location, players, board, row);
        int fromCorner = PlacementActions.selectStartCornerForRoad(scanner, location, row, column);
        while (fromCorner == 8) {
            row = PlacementActions.selectLine(scanner, board);
            column = PlacementActions.selectArea(scanner, location, players, board, row);
            fromCorner = PlacementActions.selectStartCornerForRoad(scanner, location, row, column);
        }

        int toCorner = PlacementActions.selectEndCornerForRoad(scanner, location, row, column, fromCorner);

        location.setRoad(playerId, row, column, fromCorner, toCorner);
    }
}

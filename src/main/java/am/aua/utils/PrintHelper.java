package am.aua.utils;

import am.aua.constants.Houses;
import am.aua.core.Player;
import am.aua.core.StateManager;
import am.aua.core.board.Area;
import am.aua.core.board.Board;
import am.aua.core.board.Location;
import am.aua.core.buildings.Building;
import am.aua.core.buildings.House;
import am.aua.core.buildings.Road;

import java.util.ArrayList;

public class PrintHelper {
    public final static String darkRedBackground = "\033[48;5;88m";
    public final static String darkYellowBackground  = "\033[48;5;136m";
    public final static String darkBlueBackground = "\033[48;5;18m";
    public final static String darkGreenBackground = "\033[48;5;22m";
    public final static String darkGreen = "\033[38;5;22m";
    public final static String lightYellow = "\033[38;5;229m";
    public final static String darkOrange = "\033[38;5;130m";
    public final static String lightGreen = "\033[38;5;120m";
    public final static String grey = "\033[38;5;240m";
    public final static String magenta = "\033[38;5;201m";
    private final static String reset = "\033[0m";
    public final static String emptyPointSymbol = "O";
    public final static String blockedPointSymbol = "\u00D8";
    public final static String settlementSymbol = "S";
    public final static String citySymbol = "C";

    public static void printOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + 1 + ") " + options[i]);
        }
    }

    public static void printBoard(Area[][] areas) {
        int spaceCount = 10;
        for (int i = 0; i < areas.length; i++) {
            System.out.print("Line: " + (i+1) + " ".repeat(spaceCount));
            addSpaces(areas, i, spaceCount);

            for (int j = 0; j < areas[i].length; j++) {
                Area area = areas[i][j];
                System.out.print(area.getColor() + area + " [" + (j+1) + "]" + PrintHelper.reset + " ".repeat(spaceCount - area.toString().length()) + " ".repeat(spaceCount));
            }

            addSpaces(areas, i, spaceCount);
            System.out.println();
        }
    }

    public static void printArea(Player[] players, Location location, Board board, int rowIndex, int columnIndex) {
        int spaceCount = 10;
        ArrayList<Road> roads = location.getRoadsFromArea(rowIndex, columnIndex);
        String[] symbols = getBuildingsForPrint(players, location, rowIndex, columnIndex);
        String[][] roadSymbolsByOrder = getRoadSymbolsByOrder(players, roads);

        System.out.println(" ".repeat(17) + symbols[0] + " [1]");
        System.out.println(" ".repeat(13) + (roadSymbolsByOrder[0][0] == null ?  "/" : roadSymbolsByOrder[0][0]) + " ".repeat(10) + (roadSymbolsByOrder[0][1] == null ? "\\" : roadSymbolsByOrder[0][1]));

        System.out.println(" ".repeat(spaceCount) + symbols[1] + " [2]" + " ".repeat(spaceCount-1) + symbols[2] + " [3]");
        System.out.println(" ".repeat(13) + (roadSymbolsByOrder[1][0] == null ? "|" : roadSymbolsByOrder[1][0]) + " ".repeat(2) + board.getArea(rowIndex-1, columnIndex-1) + " ".repeat(4) + (roadSymbolsByOrder[1][1] == null ? "|" : roadSymbolsByOrder[1][1]));

        System.out.println(" ".repeat(spaceCount) + symbols[3] + " [4]" + " ".repeat(spaceCount-1) + symbols[4] + " [5]");
        System.out.println(" ".repeat(13) + (roadSymbolsByOrder[2][0] == null ? "\\" : roadSymbolsByOrder[2][0]) + " ".repeat(10) + (roadSymbolsByOrder[2][1] == null ? "/" : roadSymbolsByOrder[2][1]));

        System.out.println(" ".repeat(17) + symbols[5] + " [6]");
    }

    public static String[] getBuildingsForPrint(Player[] players, Location location, int rowIndex, int columnIndex) {
        String[] symbols = new String[6];
        for(int i = 1; i < 7; i++) {
            Building building = location.getBuilding(Location.getByCorner(rowIndex, columnIndex, i));
            StringBuilder symbol = new StringBuilder(PrintHelper.getBuildingSymbol(building));
            if(building instanceof House) {
                for (Player player : players) {
                    if(player.getId() == ((House) building).getPlayerId()) {
                        symbol = new StringBuilder(player.getColor() + symbol + PrintHelper.reset);
                    }
                }
            }

            symbols[i-1] = symbol.toString();
        }

        return symbols;
    }

    public static String[][] getRoadSymbolsByOrder(Player[] players, ArrayList<Road> roads) {
        String[] firstOrderRoadSymbols = new String[2];
        String[] secondOrderRoadSymbols = new String[2];
        String[] thirdOrderRoadSymbols = new String[2];

        String color;
        for (Road road : roads) {
            color = "";
            for(Player player : players) {
                if(player.getId() == road.getPlayerId()) {
                    color = player.getColor();
                }
            }
            if(road.getToCorner() == 1) {
                if(road.getToCorner() == 2) firstOrderRoadSymbols[0] = color + "/" + reset;
                if(road.getToCorner() == 3) firstOrderRoadSymbols[1] = color + "\\" + reset;
            }
            if((road.getFromCorner() == 2 && road.getToCorner() == 4)) secondOrderRoadSymbols[0] = color + "|" + reset;
            if((road.getFromCorner() == 3 && road.getToCorner() == 5)) secondOrderRoadSymbols[1] = color + "|" + reset;
            if(road.getFromCorner() == 4 && road.getToCorner() == 6) thirdOrderRoadSymbols[0] = color + "\\" + reset;
            if(road.getFromCorner() == 5 && road.getToCorner() == 6) thirdOrderRoadSymbols[1] = color + "/" + reset;

        }

        return new String[][] {firstOrderRoadSymbols, secondOrderRoadSymbols, thirdOrderRoadSymbols};
    }

    public static String getBuildingSymbol(Building building) {
        if(building == null) return emptyPointSymbol;
        return switch (building.getHouseType()) {
            case Houses.BLOCKED -> PrintHelper.blockedPointSymbol;
            case Houses.SETTLEMENT -> PrintHelper.settlementSymbol;
            case Houses.CITY -> PrintHelper.citySymbol;
        };
    }

    private static void addSpaces(Area[][] areas, int i, int spaceCount) {
        if(areas.length - areas[i].length > 0) {
            System.out.print(" ".repeat((areas.length - areas[i].length) * spaceCount));
        }
    }

    public static void printPlayerInventory(Player player) {}
}

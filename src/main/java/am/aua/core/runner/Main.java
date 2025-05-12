package am.aua.core.runner;

import am.aua.core.Dice;
import am.aua.core.Player;
import am.aua.core.StateManager;
import am.aua.core.board.Area;
import am.aua.core.board.Board;
import am.aua.core.board.Location;
import am.aua.core.buildings.House;
import am.aua.utils.PrintHelper;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        Location location = new Location();
//        Player player = new Player(1, "Armen");
//        Player player2 = new Player(2, "Armen");
//        StateManager state = new StateManager(new Player[] {player, player2});
//        location.setSettlement(player.getId(), 3, 2, 1);
//        location.setSettlement(player.getId(), 3, 2, 5);
//        location.setSettlement(player2.getId(), 3, 2, 4);
//        location.setRoad(player.getId(), 3, 2, 1, 3);
//        location.setRoad(player.getId(), 3, 2, 3, 5);
//        location.setRoad(player.getId(), 3, 2, 1, 2);
//        location.setRoad(player2.getId(), 3, 2, 4, 6);
//        ((House) location.getBuilding(Location.getByCorner(3, 2, 5))).update();
//        PrintHelper.printBoard(board.getAreas());
//        PrintHelper.printArea(state.getPlayers(), location, 3, 2);

//        Area area = board.getAreas()[3][2];
//        System.out.println("\u001B[34m Hello World\u001B[0m sad");

        Runner runner = new Runner();

        if (args.length == 0) {
            runner.runTerminal();
        } else if(args.length == 1) {
            runner.runUI();
        }
    }
}

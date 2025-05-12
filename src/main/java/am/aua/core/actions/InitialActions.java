package am.aua.core.actions;

import am.aua.core.Player;
import am.aua.core.StateManager;
import am.aua.core.board.Board;
import am.aua.core.board.Location;
import java.util.Scanner;

public class InitialActions {
    public void startConstruction(Scanner scanner, Player[] players, Board board, Location location) {
        for (Player player : players) {
            System.out.println(player.getName() + " is your turn please set your first settlement!");
            PlacementActions.selectAndSetSettlement(scanner, location, players, board, player.getId());

            System.out.println("You set settlement now please set road near to your house: ");
            PlacementActions.selectAndSetRoad(scanner, location, players, board, player.getId());
        }
        for (int i = players.length - 1; i >= 0; i--) {
            Player player = players[i];
            System.out.println(player.getName() + " is your turn please set your second settlement!");
            PlacementActions.selectAndSetSettlement(scanner, location, players, board, player.getId());

            System.out.println("You set settlement now please set road near to your house: ");
            PlacementActions.selectAndSetRoad(scanner, location, players, board, player.getId());
        }
    }

    public void startRound(Scanner scanner, Player[] players, StateManager state, RoundActions actions) {
        for (Player player : players) {
            actions.playerTurn(scanner, state, player);
        }
    }
}

package am.aua.core.runner;

import am.aua.core.Bank;
import am.aua.core.Player;
import am.aua.core.StateManager;
import am.aua.core.actions.InitialActions;
import am.aua.core.actions.RoundActions;
import am.aua.core.board.Board;
import am.aua.core.board.Location;

import java.util.Scanner;

public class Runner {
    public void runTerminal() {
        Scanner scanner = new Scanner(System.in);
        Builder builder = new Builder();
        InitialActions initialActions = new InitialActions();

        System.out.println("Hello, Welcome to our board game Catan!");

        Player[] players = builder.buildUsers(scanner);
        Board board = new Board();
        Location location = new Location();
        Bank bank = new Bank();
        StateManager state = new StateManager(players, location, board, bank);
        RoundActions roundActions = new RoundActions();

        initialActions.startConstruction(scanner, players, board, location);
        initialActions.startRound(scanner, players, state, roundActions);
    }

    public void runUI() {


    }
}

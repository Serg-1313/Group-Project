package am.aua.core.runner;

import am.aua.core.Player;
import am.aua.utils.TerminalHelper;

import java.util.Scanner;

public class Builder {
    public Player[] buildUsers(Scanner scanner) {
        int playersCount = TerminalHelper.askUntilAnswerIsCorrect(scanner, "Please select how many users will play this game.", new String[] {"2 players (input 1)", "3 players (input 2)", "4 players (input 3)"}, false);
        Player[] players = new Player[playersCount+1];

        for (int i = 0; i < players.length; i++) {
            String playerName = TerminalHelper.askQuestionWithoutOption(scanner, "Please provide player " + (i+1) + " name");
            players[i] = new Player(i+1, playerName);
        }

        return players;
    }
}

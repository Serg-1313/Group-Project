package am.aua.core;

import am.aua.core.board.Board;
import am.aua.core.board.Location;
import am.aua.utils.ArrayHelper;
import am.aua.utils.IOHelper;

import java.io.IOException;

public class StateManager {
    private final Player[] players;
    private final Location location;
    private final Board board;
    private final Bank bank;

    public StateManager(Player[] players, Location location, Board board, Bank bank) {
        this.players = ArrayHelper.copyArray(players);
        this.location = location;
        this.board = board;
        this.bank = bank;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Location getLocation() {
        return location;
    }

    public Board getBoard() {
        return board;
    }

    public Bank getBank() {
        return bank;
    }

    public void sync() throws IOException {
        IOHelper.writeToFile(IOHelper.playerFilePath, players);
    }
}

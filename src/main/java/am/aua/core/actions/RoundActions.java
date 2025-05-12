package am.aua.core.actions;

import am.aua.constants.Resources;
import am.aua.core.Bank;
import am.aua.core.Dice;
import am.aua.core.Player;
import am.aua.core.StateManager;
import am.aua.core.board.Area;
import am.aua.exceptions.ZeroResourceException;
import am.aua.utils.PrintHelper;
import am.aua.utils.TerminalHelper;

import java.util.ArrayList;
import java.util.Scanner;

public class RoundActions {
    public void playerTurn(Scanner scanner, StateManager state, Player player) throws ZeroResourceException {
        PrintHelper.printPlayerInventory(player);
        int diceNumber = Dice.roll();
        System.out.println("Dice is rolled to " + diceNumber);

        if(diceNumber == 7) {
            throwCardsToBank(state);
            moveRobber(player, state, scanner);
            System.out.println(player.getName() + " continue the game");
        } else {
            collectCardsFromBank(state,diceNumber);
        }

        String[] actionMenu = new String[] {"Skip the turn!", "Open shop", "Bank Trade", "Use Special"};
        int action = TerminalHelper.askUntilAnswerIsCorrect(scanner, "What you want to do?", actionMenu, false);

        while (action != 1) {
            switch(action) {
                case 2: openShop();
                case 3: openTrade();
                case 4: useSpecial();
                default: break;
            }
            action = TerminalHelper.askUntilAnswerIsCorrect(scanner, "What you want to do?", actionMenu, false);
        }
    }

    public void throwCardsToBank(StateManager state) throws ZeroResourceException {
        for (Player player : state.getPlayers()) {
            int playerCardCount = player.getResourceCardsCount();
            if(playerCardCount < 8) continue;

            int cardsThatNeedToBeThrown = playerCardCount / 2;
            Resources[] playerResources = player.getResourceCardsTypes();
            for (int i = 0; i < cardsThatNeedToBeThrown; i++) {
                player.giveResourceCard(playerResources[(int)(Math.random()*playerResources.length)], state.getBank());
                playerResources = player.getResourceCardsTypes();
            }
            System.out.println(player.getName() + " your " + cardsThatNeedToBeThrown + " cards was thrown away!");
            PrintHelper.printPlayerInventory(player);
        }
    }

    public void moveRobber(Player player, StateManager state, Scanner scanner) {
        PrintHelper.printBoard(state.getBoard().getAreas());
        System.out.println(player.getName() + " please place robber!");
        int row = PlacementActions.selectLine(scanner, state.getBoard());
        int column = PlacementActions.selectArea(scanner, state.getLocation(), state.getPlayers(), state.getBoard(), row);
        state.getBoard().findAreaWithRobber().setIsRobberOverIt(false);
        state.getBoard().getArea(row, column).setIsRobberOverIt(true);
    }

    public void collectCardsFromBank(StateManager state, int diceNumber) {
        ArrayList<Area> areasCorrespondingToDice = state.getBoard().getAreasByNumber(diceNumber);
        for (int i = 1; i < 7; i++) {

        }
    }

    public void openShop() {}

    public void openTrade() {}

    public void useSpecial() {}
}

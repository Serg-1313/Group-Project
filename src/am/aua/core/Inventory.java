package am.aua.core;

import am.aua.constants.DevelopmentCards;
import am.aua.constants.Resources;
import am.aua.exception.ZeroResourceException;

import java.util.HashMap;

public abstract class Inventory {
    protected final HashMap<Resources, Integer> resourceCards = new HashMap<>();
    protected final HashMap<DevelopmentCards, Integer> developmentCards = new HashMap<>();

    public Inventory() {
        this.developmentCards.put(DevelopmentCards.MONOPOLY, 2);
        this.developmentCards.put(DevelopmentCards.KNIGHT, 14);
        this.developmentCards.put(DevelopmentCards.PLENTY, 2);
        this.developmentCards.put(DevelopmentCards.POINT, 5);
        this.developmentCards.put(DevelopmentCards.ROAD, 2);

        this.resourceCards.put(Resources.LUMBER, 19);
        this.resourceCards.put(Resources.GRAIN, 19);
        this.resourceCards.put(Resources.BRICK, 19);
        this.resourceCards.put(Resources.WOOL, 19);
        this.resourceCards.put(Resources.ORE, 19);
    }

    public void giveResourceCard(Resources resource, Inventory inventory) throws ZeroResourceException {
        if(this.resourceCards.get(resource) == 0) throw new ZeroResourceException(resource.toString());

        this.resourceCards.put(resource, inventory.resourceCards.get(resource) - 1);
        inventory.resourceCards.put(resource, inventory.resourceCards.get(resource) + 1);
    }

    public void giveDevelopmentCard(DevelopmentCards developmentCard, Inventory inventory) throws ZeroResourceException {
        if(this.developmentCards.get(developmentCard) == 0) throw new ZeroResourceException(developmentCards.toString());

        this.developmentCards.put(developmentCard, inventory.developmentCards.get(developmentCard) - 1);
        inventory.developmentCards.put(developmentCard, inventory.developmentCards.get(developmentCard) + 1);
    }
}

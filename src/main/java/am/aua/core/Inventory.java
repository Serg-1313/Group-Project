package am.aua.core;

import am.aua.constants.DevelopmentCards;
import am.aua.constants.Resources;
import am.aua.exceptions.ZeroResourceException;
import am.aua.exceptions.DevelopmentCardIsOverException;

import java.util.ArrayList;
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

    public void giveDevelopmentCard(DevelopmentCards developmentCard, Inventory inventory) throws DevelopmentCardIsOverException {
        if(this.developmentCards.get(developmentCard) == 0) throw new DevelopmentCardIsOverException(developmentCards.toString());

        this.developmentCards.put(developmentCard, inventory.developmentCards.get(developmentCard) - 1);
        inventory.developmentCards.put(developmentCard, inventory.developmentCards.get(developmentCard) + 1);
    }

    public int getResourceCardsCount() {
         int sum = 0;
         for(Resources key : this.resourceCards.keySet()) {
             sum += this.resourceCards.get(key);
         }

         return sum;
    }

    public Resources[] getResourceCardsTypes() {
        ArrayList<Resources> resources = new ArrayList<>();

        for(Resources key : this.resourceCards.keySet()) {
            if(this.resourceCards.get(key) != 0) resources.add(key);
        }

        return resources.toArray(new Resources[0]);
    }

    public HashMap<Resources, Integer> getResourceCards() {
        return resourceCards;
    }

    public HashMap<DevelopmentCards, Integer> getDevelopmentCards() {
        return developmentCards;
    }
}

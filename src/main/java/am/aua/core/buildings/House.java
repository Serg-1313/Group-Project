package am.aua.core.buildings;

import am.aua.constants.Houses;

public class House implements Building {
    private final int playerId;
    private Houses houseType;

    public House(int playerId) {
        this.playerId = playerId;
        this.houseType = Houses.SETTLEMENT;
    }

    public void update() {
        this.houseType = Houses.CITY;
    }

    public int getPlayerId() {
        return playerId;
    }

    public Houses getHouseType() {
        return houseType;
    }

    @Override
    public String toString() {
        return this.houseType.toString();
    }
}

package am.aua.core.buildings;

import am.aua.constants.Houses;

public class BlockedPoint implements Building {
    private final Houses houseType;

    public BlockedPoint() {
         this.houseType = Houses.BLOCKED;
    }

    public Houses getHouseType() {
        return houseType;
    }

    @Override
    public String toString() {
        return this.houseType.toString();
    }
}

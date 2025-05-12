package am.aua.core.board;

import am.aua.constants.Resources;
import am.aua.utils.PrintHelper;

public class ResourceArea implements Area {
    private final Resources resource;
    private final int number;
    private boolean isRobberOverIt;

    public ResourceArea(Resources resource, int number) {
        this.resource = resource;
        this.number = number;
        this.isRobberOverIt = false;
    }

    public Resources getResource() {
        return resource;
    }

    public int getNumber() {
        return number;
    }

    public String getColor() {
        return switch (resource) {
            case LUMBER -> PrintHelper.darkGreen;
            case GRAIN -> PrintHelper.lightYellow;
            case BRICK -> PrintHelper.darkOrange;
            case WOOL -> PrintHelper.lightGreen;
            case ORE -> PrintHelper.grey;
            default -> "";
        };
    }

    @Override
    public String toString() {
        return getResource().toString() + " " + getNumber();
    }

    @Override
    public boolean getIsRobberOverIt() {
        return isRobberOverIt;
    }

    @Override
    public void setIsRobberOverIt(boolean value) {
        this.isRobberOverIt = value;
    }


}

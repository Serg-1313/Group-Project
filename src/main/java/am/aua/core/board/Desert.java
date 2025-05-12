package am.aua.core.board;

import am.aua.utils.PrintHelper;

public class Desert implements Area {
    private boolean isRobberOverIt;

    public Desert() {
        isRobberOverIt = true;
    }

    @Override
    public String toString() {
        return "Desert";
    }

    public String getColor() {
        return PrintHelper.magenta;
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

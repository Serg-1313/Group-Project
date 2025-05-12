package am.aua.core;

import am.aua.utils.PrintHelper;

public class Player extends Inventory {
    private final String color;
    private final int id;
    private String name;
    private int score;

    public Player(int id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.score = 0;
        this.color = switch (id) {
            case 1 -> PrintHelper.darkRedBackground;
            case 2 -> PrintHelper.darkBlueBackground;
            case 3 -> PrintHelper.darkGreenBackground;
            case 4 -> PrintHelper.darkYellowBackground;
            default -> PrintHelper.darkRedBackground;
        };
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getColor() {
        return color;
    }

    public String toStringForFile() {
        return id + ", " + name + ", " + color;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", color=" + color + "]";
    }
}

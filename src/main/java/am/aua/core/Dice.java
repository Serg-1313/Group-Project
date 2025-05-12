package am.aua.core;

public class Dice {
    public static int roll(){
        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;
        return dice1 + dice2;
    }
}

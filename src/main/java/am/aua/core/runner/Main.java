package am.aua.core.runner;


import am.aua.exceptions.ZeroResourceException;


public class Main {
    public static void main(String[] args) throws ZeroResourceException {

        Runner runner = new Runner();

        if (args.length == 0) {
            runner.runTerminal();
        } else if(args.length == 1) {
            runner.runUI();
        }
    }
}

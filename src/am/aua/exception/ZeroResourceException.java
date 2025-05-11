package am.aua.exception;

import am.aua.constants.Resources;

public class ZeroResourceException extends Exception {
    public ZeroResourceException(String resource) {
        super("Not enough " + resource + " in bank!");
    }
}

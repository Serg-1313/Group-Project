package am.aua.exceptions;

public class ZeroResourceException extends Exception {
    public ZeroResourceException() {
    super("Zero resource found!");
  }

    public ZeroResourceException(String resource) {
        super("There is no " + resource + " available now!");
    }
}

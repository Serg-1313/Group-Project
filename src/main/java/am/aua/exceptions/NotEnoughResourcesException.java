package am.aua.exceptions;

public class NotEnoughResourcesException extends Exception {
    public NotEnoughResourcesException() {
        super("You don't have enough resources!");
    }

    public NotEnoughResourcesException(String message) {
        super(message);
    }
}

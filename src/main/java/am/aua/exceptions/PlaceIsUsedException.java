package am.aua.exception;

public class PlaceIsUsedException extends RuntimeException {
    public PlaceIsUsedException(){super("This place is used.");}
    public PlaceIsUsedException(String message) {
        super(message);
    }
}

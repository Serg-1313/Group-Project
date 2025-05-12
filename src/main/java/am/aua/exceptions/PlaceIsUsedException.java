package am.aua.exceptions;

public class PlaceIsUsedException extends RuntimeException {
    public PlaceIsUsedException(){super("This place is used.");}
    public PlaceIsUsedException(String message) {
        super(message);
    }
}

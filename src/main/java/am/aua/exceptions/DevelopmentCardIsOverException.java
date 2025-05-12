package am.aua.exceptions;

public class DevelopmentCardIsOverException extends RuntimeException {
    public DevelopmentCardIsOverException() {
        super("Development card is over!");
    }

    public DevelopmentCardIsOverException(String developmentCard) {
        super(developmentCard + " is over!");
    }
}

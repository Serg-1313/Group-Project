package am.aua.exceptions;

public class NoSettlementException extends RuntimeException {
    public NoSettlementException(String message) {
        super(message);
    }
    public NoSettlementException() {
        super("There is no settlement to build city");
    }
}

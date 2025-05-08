package am.aua.extention;

public class PlaceIsUsedException extends RuntimeException {
  public PlaceIsUsedException(String message) {
    super(message);
  }
}

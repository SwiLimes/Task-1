package exceptions;

public class PlacedInYourself extends RuntimeException {
    public PlacedInYourself() {
        super("Placed an object in itself");
    }
    public PlacedInYourself(String message) {
        super(message);
    }
}

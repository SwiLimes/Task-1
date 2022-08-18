package exceptions;

public class ItemAlreadyPlacedException extends RuntimeException {
    public ItemAlreadyPlacedException() {
        super("Item already placed");
    }
    public ItemAlreadyPlacedException(String message) {
        super(message);
    }
}

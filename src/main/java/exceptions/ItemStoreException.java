package exceptions;

public class ItemStoreException extends RuntimeException {

    public ItemStoreException() {
        super("Container is full");
    }
    public ItemStoreException(String message) {
        super(message);
    }
}

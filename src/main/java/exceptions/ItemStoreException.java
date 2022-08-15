package exceptions;

public class ItemStoreException extends Exception {

    public ItemStoreException() {
        super("Container is full");
    }
    public ItemStoreException(String message) {
        super(message);
    }
}

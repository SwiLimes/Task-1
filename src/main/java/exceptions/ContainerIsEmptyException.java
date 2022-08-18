package exceptions;

public class ContainerIsEmptyException extends RuntimeException {
    public ContainerIsEmptyException() {
        super("Container is empty");
    }
    public ContainerIsEmptyException(String message) {
        super(message);
    }
}

package exceptions;

public class AddressNotFound extends Exception {
    public static final String DEFAULT_MESSAGE = "No address with provided street name found";

    public AddressNotFound() {
        super(DEFAULT_MESSAGE);
    }
    public AddressNotFound(String message) {
        super(message);
    }
}
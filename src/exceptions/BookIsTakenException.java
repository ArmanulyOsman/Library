package exceptions;

public class BookIsTakenException extends Exception{
    public BookIsTakenException(String message) {
        super(message);
    }
}

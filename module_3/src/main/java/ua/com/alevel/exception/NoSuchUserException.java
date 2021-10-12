package ua.com.alevel.exception;

public class NoSuchUserException extends Exception {
    public NoSuchUserException() {
        super("The user with the specified parameters does not exist!");
    }
}

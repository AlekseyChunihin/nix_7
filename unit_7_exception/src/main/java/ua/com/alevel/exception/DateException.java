package ua.com.alevel.exception;

public class DateException extends Exception {

    public DateException() {
    }

    @Override
    public String toString() {
        return "Date entered incorrect";
    }
}

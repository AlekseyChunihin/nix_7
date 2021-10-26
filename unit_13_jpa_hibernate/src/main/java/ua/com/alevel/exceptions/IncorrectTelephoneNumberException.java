package ua.com.alevel.exceptions;

public class IncorrectTelephoneNumberException extends Exception {
    public IncorrectTelephoneNumberException(String telephoneNumber) {
        super("Entered telephone number " + telephoneNumber + " was incorrect!");
    }
}

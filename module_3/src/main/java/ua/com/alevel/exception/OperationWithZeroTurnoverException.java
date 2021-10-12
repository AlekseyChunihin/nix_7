package ua.com.alevel.exception;

public class OperationWithZeroTurnoverException extends Exception {
    public OperationWithZeroTurnoverException(int sum) {
        super("Operation with turnover = " + sum + " is not allowed!");
    }
}

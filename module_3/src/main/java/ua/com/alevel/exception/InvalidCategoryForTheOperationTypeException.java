package ua.com.alevel.exception;

public class InvalidCategoryForTheOperationTypeException extends Exception {
    public InvalidCategoryForTheOperationTypeException() {
        super("Operation sum was positive/negative while type category is not!");
    }
}

package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Account;
import ua.com.alevel.exception.NoSuchUserException;
import ua.com.alevel.service.AccountService;
import ua.com.alevel.service.impl.AccountServiceImpl;
import ua.com.alevel.service.impl.OperationServiceImpl;
import ua.com.alevel.entity.Category;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.service.CategoryService;
import ua.com.alevel.service.UserService;
import ua.com.alevel.service.impl.CategoryServiceImpl;
import ua.com.alevel.service.OperationService;
import ua.com.alevel.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class ManagementController {

    private static final Logger log = LoggerFactory.getLogger(ManagementController.class);

    UserService userService = new UserServiceImpl();
    AccountService accountService = new AccountServiceImpl();
    OperationService operationService = new OperationServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    Scanner scanIntValues = new Scanner(System.in);
    Scanner scanStringValues = new Scanner(System.in);

    public void modeSelectionMenu(String[] dataForConnection) {
        int id = Integer.parseInt(dataForConnection[0]);
        String telephoneNumber = dataForConnection[1];
        String login = dataForConnection[2];
        String password = dataForConnection[3];
        Scanner mainMenuChoice = new Scanner(System.in);
        printMenuText();
        String choice2 = mainMenuChoice.nextLine();
        switch (choice2) {
            case "1": {
                try {
                    if (isUserExists(login, password, id, telephoneNumber)) {
                        addOperation(id, login, password);
                    }
                } catch (NoSuchUserException e) {
                    log.error("{}", e.getMessage());
                }
            }
            break;
            case "2": {
                try {
                    if (isUserExists(login, password, id, telephoneNumber)) {
                        exportAccountStatement(login, password);
                    }
                } catch (NoSuchUserException e) {
                    log.error("{}", e.getMessage());
                }
            }
            break;
            default:
                System.out.println("You entered an invalid value!");
                break;
        }
    }

    private void exportAccountStatement(String login, String password) {
        Scanner scanChoiceFormat = new Scanner(System.in);
        System.out.println("Select account statement period:");
        System.out.println("1 - Account statement for the last n minutes");
        System.out.println("2 - Account statement for the last n hours");
        System.out.println("3 - Account statement for the last n days");
        System.out.println("4 - Account statement for the last n months");
        String timeIntervalChoice;
        boolean isTimeIntervalChoiceCorrect = false;
        while (!isTimeIntervalChoiceCorrect) {
            String choice = scanChoiceFormat.nextLine();
            switch (choice) {
                case "1": {
                    isTimeIntervalChoiceCorrect = true;
                    timeIntervalChoice = "1";
                    System.out.println("Enter count of minutes(<=43200(30 days)):");
                    int countMinutes;
                    do {
                        while (!scanIntValues.hasNextInt()) {
                            scanIntValues.next();
                            System.out.println("You have entered incorrect value, try again");
                        }
                        countMinutes = scanIntValues.nextInt();
                        if (countMinutes <= 0 || countMinutes >= 43200) {
                            System.out.println("You have entered incorrect value, try again");
                        }
                    } while (countMinutes <= 0 || countMinutes >= 43200);
                    operationService.createAccountStatementFile(login, password, countMinutes, timeIntervalChoice);
                }
                break;
                case "2": {
                    isTimeIntervalChoiceCorrect = true;
                    timeIntervalChoice = "2";
                    int countHours = getHoursDaysMonthSize();
                    operationService.createAccountStatementFile(login, password, countHours, timeIntervalChoice);
                }
                break;
                case "3": {
                    isTimeIntervalChoiceCorrect = true;
                    timeIntervalChoice = "3";
                    int countDays = getHoursDaysMonthSize();
                    operationService.createAccountStatementFile(login, password, countDays, timeIntervalChoice);
                }
                break;
                case "4": {
                    isTimeIntervalChoiceCorrect = true;
                    timeIntervalChoice = "4";
                    int countMonths = getHoursDaysMonthSize();
                    operationService.createAccountStatementFile(login, password, countMonths, timeIntervalChoice);
                }
                break;
                case "0": {
                    System.exit(0);
                }
                default: {
                    System.out.println("You entered an invalid value. Enter again please");
                }
            }
        }
    }

    public int getHoursDaysMonthSize() {
        System.out.println("Enter count of hours/days/months(<=30):");
        int size;
        do {
            while (!scanIntValues.hasNextInt()) {
                scanIntValues.next();
                System.out.println("You have entered incorrect value, try again");
            }
            size = scanIntValues.nextInt();
            if (size <= 0 || size >= 31) {
                System.out.println("You have entered incorrect value, try again");
            }
        } while (size <= 0 || size >= 31);
        return size;
    }

    private void addOperation(int id, String login, String password) {
        System.out.println("Enter the transaction amount");
        while (!scanIntValues.hasNextInt()) {
            scanIntValues.next();
            System.out.println("You have entered incorrect value, try again");
        }
        int sum = scanIntValues.nextInt();
        List<Category> categories = categoryService.findAllCategories(login, password);
        System.out.println("Choose operation category from the list");
        for (Category category : categories) {
            System.out.println(category.getName());
        }
        boolean categoryNameIsIncorrect = true;
        Category category = null;
        while (categoryNameIsIncorrect) {
            String categoryName = scanStringValues.nextLine();
            for (Category category1 : categories) {
                if (category1.getName().equals(categoryName)) {
                    category = category1;
                    categoryNameIsIncorrect = false;
                    break;
                }
            }
            if (categoryNameIsIncorrect) {
                System.out.println("There is no such category.Try Again");
            }
        }
        List<Account> accounts = accountService.findAllAccountsForUser(id, login, password);
        System.out.println("Choose your account by balance from the list");
        for (Account account : accounts) {
            System.out.println(account.getBalance());
        }
        boolean accountIsIncorrect = true;
        Account account = null;
        while (accountIsIncorrect) {
            while (!scanIntValues.hasNextInt()) {
                scanIntValues.next();
                System.out.println("You have entered incorrect value, try again");
            }
            Integer balance = scanIntValues.nextInt();
            for (Account account1 : accounts) {
                if (account1.getBalance().equals(balance)) {
                    account = account1;
                    accountIsIncorrect = false;
                    break;
                }
            }
            if (accountIsIncorrect) {
                System.out.println("There is no such balance.Try Again");
            }
        }
        Operation operation = new Operation(sum, category, account);
        operationService.addOperation(operation, login, password);
    }

    public boolean isUserExists(String login, String password, int id, String telephoneNumber) throws NoSuchUserException {
        return userService.existByTelephoneNumber(login, password, telephoneNumber) && userService.existById(login, password, id);
    }

    private void printMenuText() {
        System.out.println("\t\t\t\t\t\tMenu");
        System.out.println("Please, choose a mode (press the corresponding number):");
        System.out.println("\t1 - add operation");
        System.out.println("\t2 - Export an account statement");
    }
}

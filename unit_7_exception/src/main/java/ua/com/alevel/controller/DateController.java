package ua.com.alevel.controller;

import ua.com.alevel.entity.Date;
import ua.com.alevel.exception.DateException;
import ua.com.alevel.service.DateService;
import ua.com.alevel.utils.ConvertDateToStringUtil;
import ua.com.alevel.utils.ConvertStringToDateUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class DateController {

    DateService dateService = new DateService();
    String dateFormat;

    public void start() {
        try {
            menu();
        } catch (DateException e) {
            System.out.println("date was" + e.getMessage());
        }
    }

    public void menu() throws DateException {
        chooseInputOutputDateFormat();
        Scanner mainMenuChoice = new Scanner(System.in);
        while (true) {
            Scanner scanValue = new Scanner(System.in);
            printMenuText();
            String choice2 = mainMenuChoice.nextLine();
            switch (choice2) {
                case "1": {
                    System.out.println("Enter the first date");
                    String firstStringDate = scanValue.nextLine();
                    Date firstDate = ConvertStringToDateUtil.convertStringToDate(firstStringDate, dateFormat);
                    System.out.println("Enter the second date");
                    String secondStringDate = scanValue.nextLine();
                    Date secondDate = ConvertStringToDateUtil.convertStringToDate(secondStringDate, dateFormat);
                    ConvertStringToDateUtil.convertStringToDate(secondStringDate, dateFormat);
                    if (firstDate == null || secondDate == null) {
                        System.out.println("Dates are incorrect");
                    } else {
                        dateService.findDatesDifference(firstDate, secondDate);
                    }
                }
                break;
                case "2": {
                    System.out.println("Enter the date");
                    String firstStringDate = scanValue.nextLine();
                    Date date = ConvertStringToDateUtil.convertStringToDate(firstStringDate, dateFormat);
                    if (date == null) {
                        System.out.println("Date is incorrect");
                    } else {
                        dateService.addDateOrTimeToTheDate(date, dateFormat);
                    }
                }
                break;
                case "3": {
                    System.out.println("Enter the date");
                    String firstStringDate = scanValue.nextLine();
                    Date date = ConvertStringToDateUtil.convertStringToDate(firstStringDate, dateFormat);
                    if (date == null) {
                        System.out.println("Date is incorrect");
                    } else {
                        dateService.subtractDateOrTimeFromTheDate(date, dateFormat);
                    }
                }
                break;
                case "4": {
                    sortingDates();
                }
                break;
                case "6": {
                    chooseInputOutputDateFormat();
                }
                break;
                case "0": {
                    return;
                }
                default:
                    System.out.println("You entered an invalid value. Enter again please");
                    break;
            }
        }
    }

    private void sortingDates() {
        Scanner menuChoice = new Scanner(System.in);
        ArrayList<Date> dates = new ArrayList<>();
        while (true) {
            Scanner scanValue = new Scanner(System.in);
            System.out.println("Select type of sorting:");
            System.out.println("\t1 - ascending sort");
            System.out.println("\t2 - descending sort");
            System.out.println("\t0 - exit");
            String choice = menuChoice.nextLine();
            switch (choice) {
                case "1": {
                    System.out.println("Enter dates(if you want to stop enter 0)");
                    String stringDate = "";
                    Date date = new Date();
                    while (true) {
                        System.out.println("Enter the date");
                        stringDate = scanValue.nextLine();
                        if (stringDate.equals("0")) {
                            break;
                        }
                        date = ConvertStringToDateUtil.convertStringToDate(stringDate, dateFormat);
                        if (date == null) {
                            System.out.println("Date is incorrect");
                        } else {
                            dates.add(date);
                        }
                    }
                    ArrayList<Date> sortedDates = dateService.ascendingSort(dates);
                    for (Date date1 : sortedDates) {
                        System.out.print(ConvertDateToStringUtil.dateToString(date1, dateFormat));
                    }
                    dates.clear();
                }
                break;
                case "2": {
                    System.out.println("Enter dates(if you want to stop enter 0)");
                    String stringDate = "";
                    Date date = new Date();
                    while (true) {
                        System.out.println("Enter the date");
                        stringDate = scanValue.nextLine();
                        if (stringDate.equals("0")) {
                            break;
                        }
                        date = ConvertStringToDateUtil.convertStringToDate(stringDate, dateFormat);
                        if (date == null) {
                            System.out.println("Date is incorrect");
                        } else {
                            dates.add(date);
                        }
                    }
                    ArrayList<Date> sortedDates = dateService.descendingSort(dates);
                    for (Date date1 : sortedDates) {
                        System.out.print(ConvertDateToStringUtil.dateToString(date1, dateFormat));
                    }
                    dates.clear();
                }
                break;
                case "0": {
                    return;
                }
                default:
                    System.out.println("You entered an invalid value. Enter again please");
                    break;
            }
        }
    }

    private void printMenuText() {
        System.out.println("\t\t\t\t\t\tMenu");
        System.out.println("Date format for input/output now is : " + dateFormat);
        System.out.println("Please, choose what you want to do(press the corresponding number):");
        System.out.println("\t1 - find the difference between dates");
        System.out.println("\t2 - add time to the date");
        System.out.println("\t3 - subtract time from a date");
        System.out.println("\t4 - compare the list of dates in descending and ascending order");
        System.out.println("\t5 - select input/output date format");
        System.out.println("\t0 - exit");
    }

    private void chooseInputOutputDateFormat() {
        Scanner scanChoiceFormat = new Scanner(System.in);
        System.out.println("Select date format(default format = dd/mm/yy 00:00:00:000:");
        System.out.println("1 - dd/mm/yy 00:00:00:000");
        System.out.println("2 - m/d/yyyy 00:00:00:000");
        System.out.println("3 - mmm-d-yy 00:00:00:000");
        System.out.println("4 - dd-mmm-yyyy 00:00:00:000");
        String choice = scanChoiceFormat.nextLine();
        switch (choice) {
            case "1": {
                dateFormat = "dd/mm/yy 00:00:00:000";
            }
            break;
            case "2": {
                dateFormat = "m/d/yyyy 00:00:00:000";
            }
            break;
            case "3": {
                dateFormat = "mmm-d-yy 00:00:00:000";
            }
            break;
            case "4": {
                dateFormat = "dd-mmm-yyyy 00:00:00:000";
            }
            break;
            default:
                dateFormat = "dd/mm/yy 00:00:00:000";
                break;
        }
    }
}



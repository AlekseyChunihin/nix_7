package ua.com.alevel.CheckConvertDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatesMenu {

    public void menu() {
        Scanner scanChoice = new Scanner(System.in);
        System.out.println("enter how many dates you want to enter?");
        int size = getSize();
        //String[] dates = new String[size];
        ArrayList<Pair> dates = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String dateFormat = chooseInputDateFormat();
            System.out.println("Enter date");
            String date = scanChoice.nextLine();
            Pair pair = new Pair(date, dateFormat);
            dates.add(pair);
        }
        ArrayList<String> stringsOfNumbers = ConvertDatesToListOfStringFromNumbersUtil.getListOfStringFromNumbers(dates);
        System.out.println("Result:");
        if (!stringsOfNumbers.isEmpty()) {
            for (String stringsOfNumber : stringsOfNumbers) {
                System.out.println(stringsOfNumber);
            }
        } else System.out.println("All dates were incorrect");
    }

    private String chooseInputDateFormat() {
        String dateFormat;
        Scanner scanChoiceFormat = new Scanner(System.in);
        System.out.println("Select date format(default format = dd/mm/yy:");
        System.out.println("1 - yyyy/mm/dd - 2020/04/05");
        System.out.println("2 - dd/mm/yy - 05/04/2020");
        System.out.println("3 - mm-dd-yy - 04-05-2020");
        String choice = scanChoiceFormat.nextLine();
        switch (choice) {
            case "1": {
                dateFormat = "yyyy/mm/dd";
            }
            break;
            case "2": {
                dateFormat = "dd/mm/yy";
            }
            break;
            case "3": {
                dateFormat = "mm-dd-yy";
            }
            break;
            default:
                dateFormat = "dd/mm/yy";
                break;
        }
        return dateFormat;
    }

    public int getSize() {
        Scanner scanChoice = new Scanner(System.in);
        int size;
        do {
            while (!scanChoice.hasNextInt()) {
                scanChoice.next();
                System.out.println("You have entered incorrect value, try again");
            }
            size = scanChoice.nextInt();
            if (size <= 0) {
                System.out.println("You have entered incorrect value, try again");
            }
        } while (size <= 0);
        return size;
    }
}

package ua.com.alevel.service;

import ua.com.alevel.entity.Date;
import ua.com.alevel.utils.ConvertDateToMillisUtil;
import ua.com.alevel.utils.ConvertDateToStringUtil;
import ua.com.alevel.utils.ConvertMillisToDateUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class DateService {

    public void findDatesDifference(Date firstDate, Date secondDate) {
        long firstDateIntoMilliseconds = ConvertDateToMillisUtil.dateIntoMilliseconds(firstDate);
        long secondDateIntoMilliseconds = ConvertDateToMillisUtil.dateIntoMilliseconds(secondDate);
        long result = Math.abs(firstDateIntoMilliseconds - secondDateIntoMilliseconds);
        System.out.println("Result");
        System.out.println("Years - " + (long) ConvertMillisToDateUtil.millisecondsToYears(result));
        System.out.println("Days - " + (long) ConvertMillisToDateUtil.millisecondsToDays(result));
        System.out.println("Hours - " + (long) ConvertMillisToDateUtil.millisecondsToHours(result));
        System.out.println("Minutes - " + (long) ConvertMillisToDateUtil.millisecondsToMinutes(result));
        System.out.println("Seconds - " + (long) ConvertMillisToDateUtil.millisecondsToSeconds(result));
        System.out.println();
    }

    public void addDateOrTimeToTheDate(Date date, String dateFormat) {
        Scanner in = new Scanner(System.in);
        System.out.println("What unit of time do you want to add to the date?");
        System.out.println("1 - add years");
        System.out.println("2 - add days");
        System.out.println("3 - add hours");
        System.out.println("4 - add minutes");
        System.out.println("5 - add seconds");
        System.out.println("6 - add milliseconds");
        long convMilliseconds = 0;
        String choice = in.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Enter amount of years:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long years = in.nextLong();
                convMilliseconds = ConvertDateToMillisUtil.yearToMilliseconds(years);
                date = addMilliseconds(date, convMilliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            case "2":
                System.out.println("Enter amount of days:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long days = in.nextLong();
                convMilliseconds = ConvertDateToMillisUtil.dayToMilliseconds(days);
                date = addMilliseconds(date, convMilliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            case "3":
                System.out.println("Enter amount of hours:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long hours = in.nextLong();
                convMilliseconds = ConvertDateToMillisUtil.hoursToMilliseconds(hours);
                date = addMilliseconds(date, convMilliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            case "4":
                System.out.println("Enter amount of minutes:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long minutes = in.nextLong();
                convMilliseconds = ConvertDateToMillisUtil.minutesToMilliseconds(minutes);
                date = addMilliseconds(date, convMilliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            case "5":
                System.out.println("Enter amount of seconds:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long seconds = in.nextLong();
                convMilliseconds = ConvertDateToMillisUtil.secondsToMilliseconds(seconds);
                date = addMilliseconds(date, convMilliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            case "6":
                System.out.println("Enter amount of milliseconds:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long milliseconds = in.nextLong();
                date = addMilliseconds(date, milliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            default:
                System.out.println("You entered an invalid value. Enter again please");
        }
    }

    public void subtractDateOrTimeFromTheDate(Date date, String dateFormat) {
        Scanner in = new Scanner(System.in);
        System.out.println("What unit of time do you want to subtract from the date?");
        System.out.println("1 - subtract years");
        System.out.println("2 - subtract days");
        System.out.println("3 - subtract hours");
        System.out.println("4 - subtract minutes");
        System.out.println("5 - subtract seconds");
        System.out.println("6 - subtract milliseconds");
        long convMilliseconds = 0;
        String choice = in.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Enter amount of years:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long years = in.nextLong();
                convMilliseconds = ConvertDateToMillisUtil.yearToMilliseconds(years);
                date = subtractMilliseconds(date, convMilliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            case "2":
                System.out.println("Enter amount of days:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long days = in.nextLong();
                convMilliseconds = ConvertDateToMillisUtil.dayToMilliseconds(days);
                date = subtractMilliseconds(date, convMilliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            case "3":
                System.out.println("Enter amount of hours:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long hours = in.nextLong();
                convMilliseconds = ConvertDateToMillisUtil.hoursToMilliseconds(hours);
                date = subtractMilliseconds(date, convMilliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            case "4":
                System.out.println("Enter amount of minutes:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long minutes = in.nextLong();
                convMilliseconds = ConvertDateToMillisUtil.minutesToMilliseconds(minutes);
                date = subtractMilliseconds(date, convMilliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            case "5":
                System.out.println("Enter amount of seconds:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long seconds = in.nextLong();
                convMilliseconds = ConvertDateToMillisUtil.secondsToMilliseconds(seconds);
                date = subtractMilliseconds(date, convMilliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            case "6":
                System.out.println("Enter amount of milliseconds:");
                while (!in.hasNextLong()) {
                    in.next();
                    System.out.println("You have entered incorrect value, try again");
                }
                long milliseconds = in.nextLong();
                date = subtractMilliseconds(date, milliseconds);
                System.out.print(ConvertDateToStringUtil.dateToString(date, dateFormat));
                break;
            default:
                System.out.println("You entered an invalid value. Enter again please");
        }
    }

    public static Date subtractMilliseconds(Date date, long milliseconds) {
        long dateIntoMilliseconds = ConvertDateToMillisUtil.dateIntoMilliseconds(date);
        return ConvertMillisToDateUtil.millisecondsToDate(dateIntoMilliseconds - milliseconds);
    }

    public static Date addMilliseconds(Date date, long milliseconds) {
        long dateIntoMilliseconds = ConvertDateToMillisUtil.dateIntoMilliseconds(date);
        return ConvertMillisToDateUtil.millisecondsToDate(dateIntoMilliseconds + milliseconds);
    }

    public ArrayList<Date> ascendingSort(ArrayList<Date> dates) {
        int in, out;
        Date date;
        for (out = 1; out < dates.size(); out++) {
            date = dates.get(out);
            in = out;
            while (in > 0 && ConvertDateToMillisUtil.dateIntoMilliseconds(dates.get(in - 1)) >= ConvertDateToMillisUtil.dateIntoMilliseconds(date)) {
                dates.set(in, dates.get(in - 1));
                --in;
            }
            dates.set(in, date);
        }
        return dates;
    }

    public ArrayList<Date> descendingSort(ArrayList<Date> dates) {
        int in, out;
        Date date;
        for (out = 1; out < dates.size(); out++) {
            date = dates.get(out);
            in = out;
            while (in > 0 && ConvertDateToMillisUtil.dateIntoMilliseconds(dates.get(in - 1)) <= ConvertDateToMillisUtil.dateIntoMilliseconds(date)) {
                dates.set(in, dates.get(in - 1));
                --in;
            }
            dates.set(in, date);
        }
        return dates;
    }
}

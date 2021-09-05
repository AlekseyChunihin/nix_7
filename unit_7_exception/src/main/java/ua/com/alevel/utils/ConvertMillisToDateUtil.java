package ua.com.alevel.utils;

import ua.com.alevel.constant.DateConstants;
import ua.com.alevel.entity.Date;

public class ConvertMillisToDateUtil {

    public static double millisecondsToSeconds(long milliseconds) {
        return (milliseconds * DateConstants.SECOND);
    }

    public static double millisecondsToMinutes(long milliseconds) {
        return (milliseconds * DateConstants.MINUTE);
    }

    public static double millisecondsToHours(long milliseconds) {
        return (milliseconds * DateConstants.HOUR);
    }

    public static double millisecondsToDays(long milliseconds) {
        return (milliseconds * DateConstants.DAY);
    }

    public static double millisecondsToYears(long milliseconds) {
        double year = 0;
        int yearNum = 1;
        while (true) {
            if (milliseconds == 0) return year;
            if (Date.isLeapYear(yearNum)) {
                if (milliseconds >= DateConstants.MILLISECONDS_IN_LEAP_YEAR) {
                    milliseconds -= DateConstants.MILLISECONDS_IN_LEAP_YEAR;
                    year++;
                } else {
                    year += millisecondsToDays(milliseconds) / 366;
                    milliseconds = 0;
                }
            } else {
                if (milliseconds >= DateConstants.YEAR) {
                    milliseconds -= DateConstants.YEAR;
                    year++;
                } else {
                    year += millisecondsToDays(milliseconds) / 365;
                    milliseconds = 0;
                }
            }
            yearNum++;
        }
    }

    public static Date millisecondsToDate(long milliseconds) {
        long seconds = milliseconds / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        int month = 0;
        int currentMonth = 0;
        int year = 0;
        long milliDays = days;
        while (milliDays > DateConstants.MONTH_DAYS[currentMonth]) {
            milliDays -= DateConstants.MONTH_DAYS[currentMonth];
            if (currentMonth == 1) {
                if (Date.isLeapYear(year)) {
                    milliDays -= 1;
                }
            }
            currentMonth++;
            if (currentMonth > 11) {
                year++;
                currentMonth = 0;
            }
            month++;
        }
        Date date = new Date();
        date.setMilliseconds(milliseconds % 1000);
        date.setSeconds(seconds % 60);
        date.setMinutes(minutes % 60);
        date.setHours(hours % 24);
        if (Date.isLeapYear(year)) {
            date.setDay(((milliDays) % DateConstants.MONTH_DAYS[currentMonth]));
        } else {
            date.setDay(((milliDays) % DateConstants.MONTH_DAYS[currentMonth]) + 1);
        }
        date.setMonth(((month) % 12) + 1);
        date.setYear(year);
        return date;
    }
}

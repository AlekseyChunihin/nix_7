package ua.com.alevel.utils;

import ua.com.alevel.constant.DateConstants;
import ua.com.alevel.entity.Date;

public class ConvertDateToMillisUtil {

    public static long secondsToMilliseconds(long seconds) {
        return seconds * DateConstants.MILLISECONDS_IN_SECOND;
    }

    public static long minutesToMilliseconds(long minutes) {
        return minutes * DateConstants.MILLISECONDS_IN_MINUTE;
    }

    public static long hoursToMilliseconds(long hours) {
        return hours * DateConstants.MILLISECONDS_IN_HOUR;
    }

    public static long dayToMilliseconds(long day) {
        return day * DateConstants.MILLISECONDS_IN_DAY;
    }

    public static long yearToMilliseconds(long year) {
        long leapYear = year / 4 - (year / 100) + year / 400;
        long standardYear = year - leapYear;
        long leapMilliseconds = DateConstants.MILLISECONDS_IN_LEAP_YEAR * leapYear;
        long commonMilliseconds = DateConstants.MILLISECONDS_IN_YEAR * standardYear;
        return commonMilliseconds + leapMilliseconds;
    }

    private static long monthToMilliseconds(int month, long year) {
        if (month != 0) {
            long milliseconds = 0;
            month--;
            switch (month) {
                case 2:
                    if (Date.isLeapYear(year)) {
                        milliseconds += ConvertDateToMillisUtil.dayToMilliseconds(29);
                    } else {
                        milliseconds += ConvertDateToMillisUtil.dayToMilliseconds(28);
                    }
                    milliseconds += monthToMilliseconds(month, year);
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    milliseconds += ConvertDateToMillisUtil.dayToMilliseconds(30);
                    milliseconds += monthToMilliseconds(month, year);
                    break;
                case 0:
                    break;
                default:
                    milliseconds += ConvertDateToMillisUtil.dayToMilliseconds(31);
                    milliseconds += monthToMilliseconds(month, year);
            }
            return milliseconds;
        } else {
            return 0;
        }
    }

    public static long dateIntoMilliseconds(Date date) {
        long result = 0;
        result += yearToMilliseconds(date.getYear());
        result += monthToMilliseconds(date.getMonth(), date.getYear());
        result += dayToMilliseconds(date.getDay());
        result += hoursToMilliseconds(date.getHours());
        result += minutesToMilliseconds(date.getMinutes());
        result += secondsToMilliseconds(date.getSeconds());
        result += date.getMilliseconds();
        return result;
    }
}

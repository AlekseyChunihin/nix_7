package ua.com.alevel.utils;

import ua.com.alevel.constant.DateConstants;
import ua.com.alevel.constant.DateFormatConstants;
import ua.com.alevel.entity.Date;

public class ConvertDateToStringUtil {

    public static String dateToString(Date date, String dateFormat) {
        String stringDate = "";
        if (dateFormat.equals(DateFormatConstants.FIRST_FORMAT)) {
            System.out.println(firstFormat(date, stringDate));
        } else if (dateFormat.equals(DateFormatConstants.SECOND_FORMAT)) {
            System.out.println(secondFormat(date, stringDate));
        } else if (dateFormat.equals(DateFormatConstants.THIRD_FORMAT)) {
            System.out.println(thirdFormat(date, stringDate));
        } else if (dateFormat.equals(DateFormatConstants.FOURTH_FORMAT)) {
            System.out.println(fourthFormat(date, stringDate));
        }
        return stringDate;
    }

    private static String firstFormat(Date date, String stringDate) {
        if (date.getDay() == 0) {
            stringDate += "1";
        }
        stringDate += getTwoZero(date.getDay()) + "/";
        for (int i = 0; i < DateConstants.MONTHS_NAMES.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                stringDate += getTwoZero(date.getMonth()) + "/";
            }
        }
        stringDate += date.getYear() + " ";
        stringDate += getTwoZero(date.getHours()) + ":";
        stringDate += getTwoZero(date.getMinutes()) + ":";
        stringDate += getTwoZero(date.getSeconds()) + ":";
        stringDate += getThreeZero(date.getMilliseconds());
        return stringDate;
    }

    private static String secondFormat(Date date, String stringDate) {
        if (date.getDay() == 0) {
            stringDate += "1";
        }
        for (int i = 0; i < DateConstants.MONTHS_NAMES.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                stringDate += date.getMonth() + "/";
            }
        }
        stringDate += date.getDay() + "/";
        stringDate += date.getYear() + " ";
        stringDate += getTwoZero(date.getHours()) + ":";
        stringDate += getTwoZero(date.getMinutes()) + ":";
        stringDate += getTwoZero(date.getSeconds()) + ":";
        stringDate += getThreeZero(date.getMilliseconds());
        return stringDate;
    }

    private static String thirdFormat(Date date, String stringDate) {
        for (int i = 0; i < DateConstants.MONTHS_NAMES.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                stringDate += DateConstants.MONTHS_NAMES[i] + " ";
            }
        }
        if (date.getDay() == 0) {
            stringDate += "1";
        }
        stringDate += date.getDay() + " ";
        stringDate += date.getYear() + " ";

        stringDate += getTwoZero(date.getHours()) + ":";
        stringDate += getTwoZero(date.getMinutes()) + ":";
        stringDate += getTwoZero(date.getSeconds()) + ":";
        stringDate += getThreeZero(date.getMilliseconds());

        return stringDate;
    }

    private static String fourthFormat(Date date, String stringDate) {
        if (date.getDay() == 0) {
            stringDate += "1";
        }
        stringDate += getTwoZero(date.getDay()) + " ";

        for (int i = 0; i < DateConstants.MONTHS_NAMES.length; ++i) {
            if (i == (date.getMonth() - 1)) {
                stringDate += DateConstants.MONTHS_NAMES[i] + " ";
            }
        }
        stringDate += date.getYear() + " ";

        stringDate += getTwoZero(date.getHours()) + ":";
        stringDate += getTwoZero(date.getMinutes()) + ":";
        stringDate += getTwoZero(date.getSeconds()) + ":";
        stringDate += getThreeZero(date.getMilliseconds());

        return stringDate;
    }

    private static String getTwoZero(long time) {
        if (time < 10) {
            return "0" + time;
        }
        return time + "";
    }

    private static String getThreeZero(long milliseconds) {
        if (milliseconds < 10) {
            return "00" + milliseconds;
        }
        if (milliseconds < 100) {
            return "0" + milliseconds;
        }
        return milliseconds + "";
    }
}

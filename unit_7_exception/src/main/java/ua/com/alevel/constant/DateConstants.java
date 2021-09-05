package ua.com.alevel.constant;

public class DateConstants {

    public static final long MILLISECONDS_IN_SECOND = 1000;
    public static final long MILLISECONDS_IN_MINUTE = 60000;
    public static final long MILLISECONDS_IN_HOUR = 3600000;
    public static final long MILLISECONDS_IN_DAY = 86400000;
    public static final long MILLISECONDS_IN_YEAR = MILLISECONDS_IN_DAY * 365;
    public static final long MILLISECONDS_IN_LEAP_YEAR = MILLISECONDS_IN_YEAR + MILLISECONDS_IN_DAY;
    public static final int[] MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final String[] MONTHS_NAMES = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    public static final double MILLISECOND = 1;
    public static final double SECOND = MILLISECOND / 1000;
    public static final double MINUTE = SECOND / 60;
    public static final double HOUR = MINUTE / 60;
    public static final double DAY = HOUR / 24;

    public static final long YEAR = 31536000000L;
    public static final long LEAP_YEAR = 31622400000L;


}

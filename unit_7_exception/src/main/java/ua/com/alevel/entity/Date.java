package ua.com.alevel.entity;

public class Date {

    private long year;
    private int month;
    private long day;
    private long hours;
    private long minutes;
    private long seconds;
    private long milliseconds;

    public Date() {
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getDay() {
        return day;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public long getHours() {
        return hours;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    private static final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(long year) {
        return (year % 400 == 0 || year % 4 == 0 && year % 100 != 0);
    }

    public static boolean isValidDate(long year, int month, long day) {
        if ((month - 1) < 0 || (month - 1) >= 12) {
            return false;
        }
        int maxDate = daysInMonth[(month - 1)];
        if ((month - 1) == 1 && isLeapYear(year)) {
            maxDate = 29;
        }
        return day >= 1 && day <= maxDate;
    }
}

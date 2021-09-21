package ua.com.alevel.check_convert_date;

public class Pair {

    String dateValue;
    String dateFormat;

    public Pair(String dateValue, String dateFormat) {
        this.dateValue = dateValue;
        this.dateFormat = dateFormat;
    }

    public String getDateValue() {
        return dateValue;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "dateFormat='" + dateFormat + '\'' +
                ", dateValue='" + dateValue + '\'' +
                '}';
    }
}

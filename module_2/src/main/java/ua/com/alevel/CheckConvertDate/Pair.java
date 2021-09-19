package ua.com.alevel.CheckConvertDate;

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

    public void setDateValue(String dateValue) {
        this.dateValue = dateValue;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "dateFormat='" + dateFormat + '\'' +
                ", dateValue='" + dateValue + '\'' +
                '}';
    }
}

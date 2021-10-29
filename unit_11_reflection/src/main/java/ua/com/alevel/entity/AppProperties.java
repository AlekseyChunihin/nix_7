package ua.com.alevel.entity;

import ua.com.alevel.annotation.PropertyKey;

public class AppProperties {

    @PropertyKey("limit")
    public int limit;

    @PropertyKey("stringValue")
    public String string;

    @PropertyKey("isCreated")
    public boolean flag;

    @PropertyKey("day")
    public DayOfWeek dayOfWeek;


    public AppProperties(int limit, String string, boolean flag, DayOfWeek dayOfWeek) {
        this.limit = limit;
        this.string = string;
        this.flag = flag;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "AppProperties: {" +
                "limit=" + limit +
                ", string='" + string + '\'' +
                ", flag=" + flag +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }
}

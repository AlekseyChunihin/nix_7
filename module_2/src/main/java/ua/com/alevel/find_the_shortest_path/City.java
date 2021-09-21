package ua.com.alevel.find_the_shortest_path;

import java.util.Arrays;

public class City {

    private String cityName;
    private String[] waysToOtherCities;

    public City() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String[] getWaysToOtherCities() {
        return waysToOtherCities;
    }

    public void setWaysToOtherCities(String[] waysToOtherCities) {
        this.waysToOtherCities = waysToOtherCities;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", waysToOtherCities=" + Arrays.toString(waysToOtherCities) +
                '}';
    }
}

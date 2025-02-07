package org.example.rayweather.models;

public class Weather {
    private String day;
    private String weather;

    public Weather(String day, String weather) {
        this.day = day;
        this.weather = weather;
    }

    public String getDay() {
        return day;
    }

    public String getWeather() {
        return weather;
    }

    @Override
    public String toString() {
        return day + ": " + weather;
    }
}

package ru.soft.weatherhelper.model;

public class CityWeather {
    public final String city;
    public final String sky;
    public final boolean isRain;

    public CityWeather(String city, String sky, boolean isRain) {
        this.city = city;
        this.sky = sky;
        this.isRain = isRain;
    }
}

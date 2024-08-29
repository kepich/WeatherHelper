package ru.soft.weatherhelper.service;

import java.util.List;
import java.util.Map;

import ru.soft.weatherhelper.model.CityWeather;

public class DataModule {
    private static DataModule singleton = null;

    private static final List<String> cities = List.of(
            "Moscow",
            "Barnaul",
            "Kazan"
    );

    private static final Map<String, CityWeather> weatherMap;

    static {
        weatherMap = Map.of(
                "Moscow", new CityWeather("Moscow", "clear", false),
                "Barnaul", new CityWeather("Barnaul", "rainy", true),
                "Kazan", new CityWeather("Kazan", "cloudy", false)
        );
    }

    public static DataModule getSingleton() {
        if (singleton == null) {
            singleton = new DataModule();
        }
        return singleton;
    }

    private DataModule() {

    }

    public List<String> getCities() {
        return List.of(
                "Moscow",
                "Barnaul",
                "Kazan"
        );
    }

    public CityWeather getWeatherForCity(String city) {
        return weatherMap.get(city);
    }
}

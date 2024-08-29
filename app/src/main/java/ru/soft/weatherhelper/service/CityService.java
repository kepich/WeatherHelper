package ru.soft.weatherhelper.service;

import java.util.List;

import ru.soft.weatherhelper.model.CityWeather;

public class CityService {
    private static CityService singleton = null;

    public static CityService getSingleton() {
        if (singleton == null) {
            singleton = new CityService();
        }
        return singleton;
    }

    private final DataModule dataModule;

    private CityService() {
        dataModule = DataModule.getSingleton();
    }

    public List<String> getCities() {
        return dataModule.getCities();
    }

    public CityWeather getWeatherForCity(String city) {
        return dataModule.getWeatherForCity(city);
    }
}

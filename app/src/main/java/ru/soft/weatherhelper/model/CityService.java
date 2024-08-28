package ru.soft.weatherhelper.model;

import java.util.List;

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
}

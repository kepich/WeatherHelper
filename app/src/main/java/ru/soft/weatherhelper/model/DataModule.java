package ru.soft.weatherhelper.model;

import java.util.List;

public class DataModule {
    private static DataModule singleton = null;

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
}

package ru.soft.weatherhelper.modelView;

import androidx.lifecycle.ViewModel;

import java.util.List;

import ru.soft.weatherhelper.service.CityService;

public class CityListViewModel extends ViewModel {
    private final CityService cityService = CityService.getSingleton();

    private List<String> cities;
    public List<String> getCities() {
        if (cities == null) {
            cities = cityService.getCities();
        }
        return cities;
    }
}



package ru.soft.weatherhelper.modelView;

import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Objects;

import ru.soft.weatherhelper.model.CityWeather;
import ru.soft.weatherhelper.service.CityService;

public class CityWeatherViewModel extends ViewModel {
    private final CityService cityService = CityService.getSingleton();

    private CityWeather cityWeather;
    private String selectedCity;

    public void selectCity(String city) {
        if (!Objects.equals(selectedCity, city)) {
            cityWeather = cityService.getWeatherForCity(city);
        }
        selectedCity = city;
    }

    public CityWeather getCityWeather() {
        return cityWeather;
    }

    public String getCityName() {
        return cityWeather.city;
    }

    public String getSky() {
        return "Sky " + cityWeather.sky;
    }

    public String getRain() {
        return (cityWeather.isRain) ? "Rainy" : "No rain";
    }
}



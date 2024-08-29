package ru.soft.weatherhelper;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProviders;

import ru.soft.weatherhelper.modelView.CityWeatherViewModel;

public class WeatherActivity extends AppCompatActivity {

    public static final String CITY_TAG = "WeatherActivity.CITY_TAG";
    private CityWeatherViewModel cityWeatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cityWeatherViewModel = ViewModelProviders.of(this).get(CityWeatherViewModel.class);

        Log.i(WeatherActivity.class.getName(), String.valueOf(getIntent().getExtras()));
        cityWeatherViewModel.selectCity(getIntent().getStringExtra(CITY_TAG));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CITY_TAG, cityWeatherViewModel.getCityWeather().city);
    }
}